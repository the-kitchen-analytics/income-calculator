package com.thekitchen.incomecalculator.domain.receiptProcedure.api.rest;

import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;

import java.math.BigDecimal;

public record ReceiptProcedureView(
    String name,
    ProcedureTypeView type,
    BigDecimal price,
    BigDecimal workerIncome
) {
}
