package com.alves.personalbudget.resource;

import com.alves.personalbudget.dto.BudgetResumeDTO;
import com.alves.personalbudget.event.ResourceCreatedEvent;
import com.alves.personalbudget.exception.NonExistentOrInactivePersonException;
import com.alves.personalbudget.exceptionhandler.RestError;
import com.alves.personalbudget.filter.BudgetFilter;
import com.alves.personalbudget.model.Budget;
import com.alves.personalbudget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budget")
public class BudgetResource {

    @Autowired
    private BudgetService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    HttpServletResponse response;

    @GetMapping("/{id}")
    public ResponseEntity<Budget> findById(@PathVariable Long id) {
        Optional<Budget> budget = service.findById(id);
        return budget.isPresent() ? ResponseEntity.ok(budget.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Budget> save(@Valid @RequestBody Budget budget) {
        Budget budgetPersisted = service.save(budget);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, budgetPersisted.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetPersisted);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> update(@PathVariable Long id, @Valid @RequestBody Budget budget) {
        try {
            Budget budgetPersisted = service.update(id, budget);
            return ResponseEntity.ok(budgetPersisted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Page<Budget> find(BudgetFilter budgetFilter, Pageable pageable) {
        return service.find(budgetFilter, pageable);
    }

    @GetMapping(path = "/resume")
    public Page<BudgetResumeDTO> resume(BudgetFilter budgetFilter, Pageable pageable) {
        return service.resume(budgetFilter, pageable);
    }

    @ExceptionHandler({ NonExistentOrInactivePersonException.class })
    public ResponseEntity<Object> handleNonExistentOrInactivePersonException(NonExistentOrInactivePersonException ex) {
        String userMessage = messageSource.getMessage("non-existent-or-inactive-person", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.toString();
        List<RestError> restErrors = Arrays.asList(new RestError(userMessage, developerMessage));
        return ResponseEntity.badRequest().body(restErrors);
    }

}
