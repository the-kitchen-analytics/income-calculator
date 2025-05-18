package com.thekitchen.incomecalculator.model;

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
