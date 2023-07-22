package com.thekitchen.incomecalculator.controller.model;

import java.math.BigDecimal;

public record ProcedureView(
    String id,
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
