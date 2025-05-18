package com.thekitchen.incomecalculator.domain.procedure.api.rest;

import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;

import java.math.BigDecimal;

public record ProcedureRequest(
    String name,
    ProcedureTypeView type,
    WorkerCategoryView workerCategory,
    BigDecimal price,
    BigDecimal workerIncome
) {

  public static ProcedureRequest fromDetails(
      String name,
      ProcedureTypeView procedureType,
      PriceDetails details,
      BigDecimal workerIncome) {

    return new ProcedureRequest(
        name,
        procedureType,
        details.workerCategory(),
        details.price(),
        workerIncome
    );
  }

}
