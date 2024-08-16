package com.thekitchen.incomecalculator.controller.user;

public record CreateUserRequest(
    String name,
    String email,
    String password,
    WorkerCategory workerCategory
) {

}
