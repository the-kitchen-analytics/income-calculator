package com.thekitchen.incomecalculator.service.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Procedure(
    UUID id,
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
