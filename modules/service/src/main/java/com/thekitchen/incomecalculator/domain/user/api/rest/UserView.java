package com.thekitchen.incomecalculator.domain.user.api.rest;

import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;

public record UserView(
    String id,
    String uid,
    String name,
    String email,
    WorkerCategoryView workerCategory
) {

}
