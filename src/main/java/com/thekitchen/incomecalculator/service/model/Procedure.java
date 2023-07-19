package com.thekitchen.incomecalculator.service.model;

import java.math.BigDecimal;

public record Procedure(
    String id,
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
