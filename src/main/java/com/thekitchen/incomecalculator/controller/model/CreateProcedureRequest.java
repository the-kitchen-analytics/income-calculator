package com.thekitchen.incomecalculator.controller.model;

import java.util.List;

public record CreateProcedureRequest(
    String name,
    ProcedureType type,
    List<PriceDetails> prices
) {

}
