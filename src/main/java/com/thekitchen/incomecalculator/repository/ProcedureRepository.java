package com.thekitchen.incomecalculator.repository;

import com.thekitchen.incomecalculator.service.model.Procedure;
import com.thekitchen.incomecalculator.service.model.ProcedureType;
import com.thekitchen.incomecalculator.service.model.WorkerCategory;
import java.util.List;

public interface ProcedureRepository extends Repository<Procedure, String> {

  List<Procedure> findAllByWorkerCategory(WorkerCategory workerCategory);

  List<Procedure> findAllByType(ProcedureType type);

  List<Procedure> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type);
}
