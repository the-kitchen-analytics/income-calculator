package com.thekitchen.incomecalculator.domain.receipt.api.rest;

import com.thekitchen.incomecalculator.domain.receiptProcedure.api.rest.ReceiptProcedureView;

import java.time.Instant;
import java.util.List;

public record ReceiptRequest(
    String uid,
    Instant date,
    List<ReceiptProcedureView> procedures
) {

}
