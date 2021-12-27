package com.alves.personalbudget.repository;

import com.alves.personalbudget.dto.BudgetResumeDTO;
import com.alves.personalbudget.filter.BudgetFilter;
import com.alves.personalbudget.model.Budget;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomizeBudgetRepositoryImpl implements  CustomizeBudgetRepository{

    @PersistenceContext
    private EntityManager manager;

    public Page<Budget> find(BudgetFilter budgetFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Budget> criteria = builder.createQuery(Budget.class);
        Root<Budget> root = criteria.from(Budget.class);

        Predicate[] predicates = addRestrictions(budgetFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Budget> query = manager.createQuery(criteria);
        addPagingRestrictions(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(budgetFilter));
    }

    private Predicate[] addRestrictions(BudgetFilter budgetFilter, CriteriaBuilder builder,
                                        Root<Budget> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(!ObjectUtils.isEmpty(budgetFilter.getDescription())) {
            predicates.add(builder.like(
                    builder.lower(root.get("description")), "%" + budgetFilter.getDescription().toLowerCase() + "%"));
        }

        if (budgetFilter.getDueDateOf() != null) {
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("dueDate"), budgetFilter.getDueDateOf()));
        }

        if (budgetFilter.getDueDateUntil() != null) {
            predicates.add(
                    builder.lessThanOrEqualTo(root.get("paymentDate"), budgetFilter.getDueDateUntil()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    @Override
    public Page<BudgetResumeDTO> resume(BudgetFilter budgetFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BudgetResumeDTO> criteria = builder.createQuery(BudgetResumeDTO.class);
        Root<Budget> root = criteria.from(Budget.class);

        criteria.select(builder.construct(BudgetResumeDTO.class
                , root.get("id"), root.get("description")
                , root.get("dueDate"), root.get("paymentDate")
                , root.get("price"), root.get("kind")
                , root.get("category").get("name")
                , root.get("person").get("name")));

        Predicate[] predicates = addRestrictions(budgetFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<BudgetResumeDTO> query = manager.createQuery(criteria);
        addPagingRestrictions(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(budgetFilter));
    }

    private void addPagingRestrictions(TypedQuery<?> query, Pageable pageable) {
        int currencyPage = pageable.getPageNumber();
        int totalRecordsPerPage = pageable.getPageSize();
        int firstPageRecord = currencyPage * totalRecordsPerPage;

        query.setFirstResult(firstPageRecord);
        query.setMaxResults(totalRecordsPerPage);
    }

    private Long total(BudgetFilter budgetFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Budget> root = criteria.from(Budget.class);

        Predicate[] predicates = addRestrictions(budgetFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }
}
