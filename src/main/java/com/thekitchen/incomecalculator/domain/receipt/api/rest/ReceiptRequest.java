package com.thekitchen.incomecalculator.domain.receipt.api.rest;

import com.thekitchen.incomecalculator.domain.procedure.api.rest.ProcedureView;

import java.time.Instant;
import java.util.List;

public record ReceiptRequest(
    String uid,
    Instant date,
    List<ProcedureView> procedures
) {

}
