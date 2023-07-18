package com.thekitchen.incomecalculator.controller.model;

import java.math.BigDecimal;

public record ProcedureRequest(
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
