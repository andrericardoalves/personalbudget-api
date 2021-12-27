package com.alves.personalbudget.repository;

import com.alves.personalbudget.dto.BudgetResumeDTO;
import com.alves.personalbudget.filter.BudgetFilter;
import com.alves.personalbudget.model.Budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomizeBudgetRepository {
    public Page<Budget> find(BudgetFilter budgetFilter, Pageable pageable);
    public Page<BudgetResumeDTO> resume(BudgetFilter budgetFilter, Pageable pageable);
}
