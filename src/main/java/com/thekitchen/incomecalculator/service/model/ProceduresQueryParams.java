package com.thekitchen.incomecalculator.service.model;

import com.thekitchen.incomecalculator.controller.model.ProcedureType;
import com.thekitchen.incomecalculator.controller.model.WorkerCategory;

import java.util.Optional;

public record ProceduresQueryParams(Optional<WorkerCategory> workerCategory, Optional<ProcedureType> type) {

}
