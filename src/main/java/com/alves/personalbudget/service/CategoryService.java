package com.alves.personalbudget.service;

import com.alves.personalbudget.model.Category;
import com.alves.personalbudget.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category update(Long id, Category category) {
        Category categoryPersisted = findById(id).get();
        BeanUtils.copyProperties(category, categoryPersisted, "id");
        return repository.save(categoryPersisted);
    }

    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }
}
