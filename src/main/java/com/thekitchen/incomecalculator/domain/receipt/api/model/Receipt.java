package com.thekitchen.incomecalculator.domain.receipt.api.model;

import com.thekitchen.incomecalculator.domain.procedure.api.model.model.Procedure;

import java.time.Instant;
import java.util.List;

public record Receipt(
    String id,
    String uid,
    Instant date,
    Instant dateCreated,
    List<Procedure> procedures
) {

}
