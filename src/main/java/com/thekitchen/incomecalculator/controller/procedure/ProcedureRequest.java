package com.thekitchen.incomecalculator.controller.procedure;

import com.thekitchen.incomecalculator.controller.user.WorkerCategory;

import java.math.BigDecimal;

public record ProcedureRequest(
    String name,
    ProcedureType type,
    WorkerCategory workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
