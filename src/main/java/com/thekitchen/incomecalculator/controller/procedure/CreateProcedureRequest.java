package com.thekitchen.incomecalculator.controller.procedure;

import java.util.List;

public record CreateProcedureRequest(
    String name,
    ProcedureType type,
    List<PriceDetails> prices
) {

}
