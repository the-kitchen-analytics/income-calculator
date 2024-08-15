package com.thekitchen.incomecalculator.controller.model;

import com.thekitchen.incomecalculator.service.model.Procedure;

import java.time.Instant;
import java.util.List;

public record ReceiptRequest(
    String uid,
    Instant date,
    List<Procedure> procedures
) {

}
