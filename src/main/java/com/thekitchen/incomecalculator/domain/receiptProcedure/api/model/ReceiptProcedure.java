package com.thekitchen.incomecalculator.domain.receiptProcedure.api.model;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;

import java.math.BigDecimal;

public record ReceiptProcedure(
    String name,
    ProcedureType type,
    BigDecimal price,
    BigDecimal workerIncome
) {
}
