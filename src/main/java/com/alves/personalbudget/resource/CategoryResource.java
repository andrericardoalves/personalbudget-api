package com.alves.personalbudget.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import com.alves.personalbudget.event.ResourceCreatedEvent;
import com.alves.personalbudget.model.Category;
import com.alves.personalbudget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> add(@Valid @RequestBody Category category, HttpServletResponse response) {
        Category persistedCategory = service.save(category);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, persistedCategory.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(persistedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = service.findById(id);

        return category.isPresent() ? ResponseEntity.ok(category.get()) : ResponseEntity.notFound().build();
    }

}
