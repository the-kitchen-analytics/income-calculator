package com.thekitchen.incomecalculator.controller.model;

import java.math.BigDecimal;

public record PriceDetails(
    BigDecimal price,
    BigDecimal workerRate,
    WorkerCategory workerCategory
) {

}
