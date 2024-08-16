package com.thekitchen.incomecalculator.domain.procedure.api.model.model;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;

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
