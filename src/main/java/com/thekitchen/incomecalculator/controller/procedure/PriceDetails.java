package com.thekitchen.incomecalculator.controller.procedure;

import com.thekitchen.incomecalculator.controller.user.WorkerCategory;

import java.math.BigDecimal;

public record PriceDetails(
    BigDecimal price,
    BigDecimal workerRate,
    WorkerCategory workerCategory
) {

}
