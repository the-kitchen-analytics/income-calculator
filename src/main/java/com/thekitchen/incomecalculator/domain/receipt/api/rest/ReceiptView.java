package com.thekitchen.incomecalculator.domain.receipt.api.rest;

import com.thekitchen.incomecalculator.domain.receiptProcedure.api.rest.ReceiptProcedureView;

import java.time.Instant;
import java.util.List;

public record ReceiptView(
    String id,
    String uid,
    Instant date,
    Instant dateCreated,
    List<ReceiptProcedureView> procedures
) {

}
