package com.thekitchen.incomecalculator.model;

public record User(
    String id,
    String uid,
    String name,
    String email,
    WorkerCategory workerCategory
) {

}
