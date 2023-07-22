package com.thekitchen.incomecalculator.controller.model;

import java.time.Instant;
import java.util.List;

public record ReceiptView(
    String id,
    String uid,
    Instant date,
    Instant dateCreated,
    List<ProcedureView> procedures
) {

}
