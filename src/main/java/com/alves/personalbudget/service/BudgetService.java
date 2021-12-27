package com.alves.personalbudget.service;

import com.alves.personalbudget.dto.BudgetResumeDTO;
import com.alves.personalbudget.exception.NonExistentOrInactivePersonException;
import com.alves.personalbudget.filter.BudgetFilter;
import com.alves.personalbudget.model.Budget;
import com.alves.personalbudget.model.Person;
import com.alves.personalbudget.repository.BudgetRepository;
import com.alves.personalbudget.repository.CustomizeBudgetRepositoryImpl;
import com.alves.personalbudget.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository repository;

    @Autowired
    private CustomizeBudgetRepositoryImpl repositoryCustomBudget;

    @Autowired
    private PersonRepository personRepository;

    public Budget save(Budget budget) {
        Optional<Person> person = personRepository.findById(budget.getPerson().getId());
        if (person.isEmpty() || person.get().isInActive()) {
            throw new NonExistentOrInactivePersonException();
        }

        return repository.save(budget);
    }

    public Budget update(Long id, Budget budget) {
        Budget budgetPersisted = findBudgetExist(id);
        if (!budgetPersisted.getPerson().equals(budgetPersisted.getPerson())) {
            validPerson(budget);
        }

        BeanUtils.copyProperties(budget, budgetPersisted, "id");

        return repository.save(budgetPersisted);
    }

    private void validPerson(Budget budget) {
        Optional<Person> person = null;
        if (budget.getPerson().getId() != null) {
            person = personRepository.findById(budget.getPerson().getId());
        }

        if (person.isEmpty() || person.get().isInActive()) {
            throw new NonExistentOrInactivePersonException();
        }
    }

    private Budget findBudgetExist(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Optional<Budget> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Page<Budget> find(BudgetFilter budgetFilter, Pageable pageable) {
        return repositoryCustomBudget.find(budgetFilter, pageable);
    }

    public Page<BudgetResumeDTO> resume(BudgetFilter budgetFilter, Pageable pageable) {
        return  repositoryCustomBudget.resume(budgetFilter, pageable);
    }
}
