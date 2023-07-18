package com.thekitchen.incomecalculator.firebase.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.firebase.entity.FirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class GenericFirebaseRepository<M, E extends FirebaseEntity> {

  private static final Long DEFAULT_WAIT_INTERVAL_MILLIS = 600000L;

  private final FirebaseEntityMapper<M, E> mapper;
  private final Firestore firestore;
  private final String collectionName;
  private final Supplier<UUID> uuidSupplier;
  private final Class<E> entityClass;

  private final Function<ApiFuture<DocumentSnapshot>, DocumentSnapshot> apiFutureMapper =
      apiFuture -> {
        try {
          return apiFuture.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      };

  @SneakyThrows
  public List<M> getAll() {
    var querySnapshot = getCollectionRef()
        .get()
        .get();

    return querySnapshot.getDocuments()
        .stream()
        .map(this::toModel)
        .toList();
  }

  public Optional<M> getById(String id) {
    return Optional.of(getDocumentRef(id))
        .map(DocumentReference::get)
        .map(this.apiFutureMapper)
        .map(this::toModel);
  }

  public M save(M model) {
    var id = generateId(model);
    replaceDocument(id, model);
    return getById(id).orElseThrow();
  }

  public M update(String id, M model) {
    replaceDocument(id, model);
    return getById(id).orElseThrow();
  }

  @SneakyThrows
  public void delete(String id) {
    getDocumentRef(id)
        .delete()
        .get();
  }

  protected CollectionReference getCollectionRef() {
    return firestore.collection(collectionName);
  }

  protected String generateId(M entity) {
    return uuidSupplier.get().toString();
  }

  private DocumentReference getDocumentRef(String id) {
    return getCollectionRef().document(id);
  }

  @SneakyThrows
  private void replaceDocument(String id, M model) {
    var documentRef = getDocumentRef(id);
    documentRef.set(mapper.toEntity(model))
        .get(DEFAULT_WAIT_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
  }

  private M toModel(DocumentSnapshot document) {
    return Optional.ofNullable(document.toObject(entityClass))
        .map(entity -> mapper.toModel(document.getId(), entity))
        .orElseThrow();
  }
}

