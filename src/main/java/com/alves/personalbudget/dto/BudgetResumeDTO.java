package com.alves.personalbudget.dto;

import com.alves.personalbudget.model.BudgetKind;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetResumeDTO {
    private Long id;
    private String description;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private BigDecimal price;
    private BudgetKind kind;
    private String category;
    private String person;
}
