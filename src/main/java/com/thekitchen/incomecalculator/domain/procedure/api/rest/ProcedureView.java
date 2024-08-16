package com.thekitchen.incomecalculator.domain.procedure.api.rest;

import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;

import java.math.BigDecimal;

public record ProcedureView(
    String id,
    String name,
    ProcedureTypeView type,
    WorkerCategoryView workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

}
