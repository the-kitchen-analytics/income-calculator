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
import java.util.UUID;
import java.util.function.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedureFirebaseRepository
    extends GenericFirebaseRepository<Procedure, ProcedureFirebaseEntity>
    implements ProcedureRepository {

  private static final String COLLECTION_NAME = "procedures_v2";

  public ProcedureFirebaseRepository(
      FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> mapper,
      Firestore firestore,
      Supplier<UUID> uuidSupplier) {
    super(mapper, firestore, COLLECTION_NAME, uuidSupplier, ProcedureFirebaseEntity.class);
  }

  @Override
  public List<Procedure> getAll() {
    return super.getAll();
  }

  @Override
  public Optional<Procedure> getById(UUID id) {
    Objects.requireNonNull(id, "ID cannot be null");
    return super.getById(id.toString());
  }

  @Override
  public Procedure save(Procedure procedure) {
    Objects.requireNonNull(procedure, "Procedure cannot be null");
    return super.save(procedure);
  }

  @Override
  public List<Procedure> saveAll(Collection<Procedure> procedures) {
    Objects.requireNonNull(procedures, "Procedures cannot be null");
    return procedures.stream()
        .map(this::save)
        .toList();
  }

  @Override
  public Procedure update(UUID id, Procedure procedure) {
    Objects.requireNonNull(procedure, "Procedure cannot be null");
    return super.update(id.toString(), procedure);
  }

  @Override
  public void delete(UUID id) {
    Objects.requireNonNull(id, "ID cannot be null");
    super.delete(id.toString());
  }

  @Override
  public void deleteAll(Collection<UUID> ids) {
    Objects.requireNonNull(ids, "IDs cannot be null");
    ids.forEach(this::delete);
  }
}
