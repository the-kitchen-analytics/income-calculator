package com.thekitchen.incomecalculator.domain.procedure.repository;

import com.thekitchen.incomecalculator.domain.procedure.api.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.shared.repository.Repository;

import java.util.List;

public interface ProcedureRepository extends Repository<Procedure, String> {

  List<Procedure> findAllByWorkerCategory(WorkerCategory workerCategory);

  List<Procedure> findAllByType(ProcedureType type);

  List<Procedure> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type);
}
