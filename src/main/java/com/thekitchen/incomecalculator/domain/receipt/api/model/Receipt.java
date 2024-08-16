package com.thekitchen.incomecalculator.domain.receipt.api.model;

import com.thekitchen.incomecalculator.domain.receiptProcedure.api.model.ReceiptProcedure;

import java.time.Instant;
import java.util.List;

public record Receipt(
    String id,
    String uid,
    Instant date,
    Instant dateCreated,
    List<ReceiptProcedure> procedures
) {

}
