package com.thekitchen.incomecalculator.repository.impl.procedure;

import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.model.Procedure;
import com.thekitchen.incomecalculator.model.ProcedureType;
import com.thekitchen.incomecalculator.model.WorkerCategory;
import com.thekitchen.incomecalculator.repository.api.ProcedureRepository;
import com.thekitchen.incomecalculator.repository.impl.GenericCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProcedureRepositoryImpl
    extends GenericCrudRepository<Procedure>
    implements ProcedureRepository {

  public ProcedureRepositoryImpl(final FirebaseCrudApi<Procedure> crudApi) {
    super(crudApi);
  }

  @Override
  public List<Procedure> findAllByWorkerCategory(WorkerCategory workerCategory) {
    Objects.requireNonNull(workerCategory, "WorkerCategory cannot be null");
    return getAll().stream()
        .filter(procedure -> procedure.workerCategory().equals(workerCategory))
        .toList();
  }

  @Override
  public List<Procedure> findAllByType(ProcedureType type) {
    Objects.requireNonNull(type, "ProcedureType cannot be null");
    return getAll().stream()
        .filter(procedure -> procedure.type().equals(type))
        .toList();
  }

  @Override
  public List<Procedure> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type) {
    Objects.requireNonNull(workerCategory, "WorkerCategory cannot be null");
    Objects.requireNonNull(type, "ProcedureType cannot be null");
    return getAll().stream()
        .filter(procedure -> procedure.workerCategory().equals(workerCategory))
        .filter(procedure -> procedure.type().equals(type))
        .toList();
  }
}
