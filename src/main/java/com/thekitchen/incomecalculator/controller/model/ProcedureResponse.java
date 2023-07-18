package com.thekitchen.incomecalculator.controller.model;

import java.math.BigDecimal;
import java.util.UUID;

public record ProcedureResponse(
    UUID id,
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
