package com.thekitchen.incomecalculator.controller.receipt;

import com.thekitchen.incomecalculator.controller.procedure.ProcedureView;

import java.time.Instant;
import java.util.List;

public record ReceiptRequest(
    String uid,
    Instant date,
    List<ProcedureView> procedures
) {

}
