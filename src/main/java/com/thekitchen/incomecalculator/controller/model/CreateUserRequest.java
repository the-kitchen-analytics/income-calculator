package com.thekitchen.incomecalculator.controller.model;

import com.thekitchen.incomecalculator.service.model.WorkerCategory;

public record CreateUserRequest(
    String name,
    String email,
    String password,
    WorkerCategory workerCategory
) {

}
