package com.thekitchen.incomecalculator.domain.procedure.api.rest;

import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;

import java.math.BigDecimal;

public record PriceDetails(
    BigDecimal price,
    BigDecimal workerRate,
    WorkerCategoryView workerCategory
) {

}
