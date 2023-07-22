package com.thekitchen.incomecalculator.controller.model;

import com.thekitchen.incomecalculator.service.model.WorkerCategory;

public record UserView(
    String id,
    String uid,
    String name,
    String email,
    WorkerCategory workerCategory
) {

}
