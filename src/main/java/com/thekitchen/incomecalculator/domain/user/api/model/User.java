package com.thekitchen.incomecalculator.domain.user.api.model;

import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;

public record User(
    String id,
    String uid,
    String name,
    String email,
    WorkerCategory workerCategory
) {

}
