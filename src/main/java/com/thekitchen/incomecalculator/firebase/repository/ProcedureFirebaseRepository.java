package com.thekitchen.incomecalculator.firebase.repository;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.config.firebase.FirebaseConfig.CollectionName;
import com.thekitchen.incomecalculator.firebase.entity.ProcedureFirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.repository.ProcedureRepository;
import com.thekitchen.incomecalculator.service.model.Procedure;
import com.thekitchen.incomecalculator.service.model.ProcedureType;
import com.thekitchen.incomecalculator.service.model.WorkerCategory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProcedureFirebaseRepository
    extends GenericFirebaseRepository<Procedure, ProcedureFirebaseEntity>
    implements ProcedureRepository {

  public ProcedureFirebaseRepository(
      FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> mapper,
      Firestore firestore) {
    super(mapper, firestore, CollectionName.PROCEDURES.getValue(), ProcedureFirebaseEntity.class);
  }

  @Override
  public List<Procedure> getAll() {
    return super.getAll();
  }

  @Override
  public Optional<Procedure> getById(String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    return super.getById(id);
  }

  @Override
  public Procedure save(Procedure procedure) {
    Objects.requireNonNull(procedure, "Procedure cannot be null");
    return super.create(procedure);
  }

  @Override
  public List<Procedure> saveAll(Collection<Procedure> procedures) {
    Objects.requireNonNull(procedures, "Procedures cannot be null");
    return procedures.stream()
        .map(this::create)
        .toList();
  }

  @Override
  public Procedure update(String id, Procedure procedure) {
    Objects.requireNonNull(procedure, "Procedure cannot be null");
    return super.update(id, procedure);
  }

  @Override
  public void delete(String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    super.delete(id);
  }

  @Override
  public void deleteAll(Collection<String> ids) {
    Objects.requireNonNull(ids, "IDs cannot be null");
    super.deleteAll(ids);
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
