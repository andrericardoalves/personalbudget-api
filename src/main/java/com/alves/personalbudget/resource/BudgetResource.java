package com.alves.personalbudget.resource;

import com.alves.personalbudget.event.ResourceCreatedEvent;
import com.alves.personalbudget.model.Budget;
import com.alves.personalbudget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
}
