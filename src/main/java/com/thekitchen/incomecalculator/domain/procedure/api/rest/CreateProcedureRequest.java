package com.thekitchen.incomecalculator.domain.procedure.api.rest;

import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;

import java.util.List;

public record CreateProcedureRequest(
    String name,
    ProcedureTypeView type,
    List<PriceDetails> prices
) {

}
