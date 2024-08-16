package com.thekitchen.incomecalculator.controller.user;

public record UserView(
    String id,
    String uid,
    String name,
    String email,
    WorkerCategory workerCategory
) {

}
