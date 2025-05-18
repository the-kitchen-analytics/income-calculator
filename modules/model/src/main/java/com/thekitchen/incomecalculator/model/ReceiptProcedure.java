package com.thekitchen.incomecalculator.model;

import java.math.BigDecimal;

public record ReceiptProcedure(
    String name,
    ProcedureType type,
    BigDecimal price,
    BigDecimal workerIncome
) {
}
