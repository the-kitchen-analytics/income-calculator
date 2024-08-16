package com.thekitchen.incomecalculator.service.model;

import com.thekitchen.incomecalculator.controller.procedure.ProcedureType;
import com.thekitchen.incomecalculator.controller.user.WorkerCategory;

import java.util.Optional;

public record ProceduresQueryParams(Optional<WorkerCategory> workerCategory, Optional<ProcedureType> type) {

}
