package com.thekitchen.incomecalculator.firebase.repository;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.firebase.entity.ProcedureFirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.repository.ProcedureRepository;
import com.thekitchen.incomecalculator.service.model.Procedure;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedureFirebaseRepository
    extends GenericFirebaseRepository<Procedure, ProcedureFirebaseEntity>
    implements ProcedureRepository {

  private static final String COLLECTION_NAME = "procedures_v2";

  public ProcedureFirebaseRepository(
      FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> mapper,
      Firestore firestore) {
    super(mapper, firestore, COLLECTION_NAME, ProcedureFirebaseEntity.class);
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
    ids.forEach(this::delete);
  }
}
