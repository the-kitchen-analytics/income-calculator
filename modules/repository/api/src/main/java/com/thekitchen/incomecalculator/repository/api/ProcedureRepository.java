package com.thekitchen.incomecalculator.repository.api;

import com.thekitchen.incomecalculator.model.Procedure;
import com.thekitchen.incomecalculator.model.ProcedureType;
import com.thekitchen.incomecalculator.model.WorkerCategory;

import java.util.List;

public interface ProcedureRepository extends CrudRepository<Procedure, String> {

  List<Procedure> findAllByWorkerCategory(WorkerCategory workerCategory);

  List<Procedure> findAllByType(ProcedureType type);

  List<Procedure> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type);
}
