package com.thekitchen.incomecalculator.domain.user.api.rest;

import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;

public record CreateUserRequest(
    String name,
    String email,
    String password,
    WorkerCategoryView workerCategory
) {

}
