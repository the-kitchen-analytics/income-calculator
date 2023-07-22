package com.thekitchen.incomecalculator.firebase.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.thekitchen.incomecalculator.firebase.entity.FirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class GenericFirebaseRepository<M, E extends FirebaseEntity> {

  private static final Long DEFAULT_WAIT_INTERVAL_MILLIS = 600000L;

  private final FirebaseEntityMapper<M, E> mapper;
  private final Firestore firestore;
  private final String collectionName;
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
    return Stream.of(getCollectionRef())
        .map(CollectionReference::get)
        .map(this::await)
        .map(QuerySnapshot::getDocuments)
        .flatMap(Collection::stream)
        .map(this::toModel)
        .toList();
  }

  public Optional<M> getById(String id) {
    return Optional.of(getDocumentRef(id))
        .map(DocumentReference::get)
        .map(this.apiFutureMapper)
        .map(this::toModel);
  }

  @SneakyThrows
  public M create(M model) {
    return Stream.of(model)
        .map(mapper::toEntity)
        .map(entity -> getCollectionRef().add(entity))
        .map(this::await)
        .map(DocumentReference::get)
        .map(this.apiFutureMapper)
        .map(this::toModel)
        .findFirst()
        .orElseThrow();
  }

  public M update(String id, M model) {
    return Stream.of(getDocumentRef(id))
        .peek(documentRef -> documentRef.set(mapper.toEntity(model)))
        .map(DocumentReference::get)
        .map(this.apiFutureMapper)
        .map(this::toModel)
        .findFirst()
        .orElseThrow();
  }

  @SneakyThrows
  public void delete(String id) {
    Stream.of(id)
        .map(this::getDocumentRef)
        .map(DocumentReference::delete)
        .forEach(this::await);
  }

  public void deleteAll(Collection<String> ids) {
    var batch = firestore.batch();

    ids.stream()
        .map(this::getDocumentRef)
        .forEach(batch::delete);

    await(batch.commit());
  }

  private CollectionReference getCollectionRef() {
    return firestore.collection(collectionName);
  }

  private DocumentReference getDocumentRef(String id) {
    return getCollectionRef().document(id);
  }

  private M toModel(DocumentSnapshot document) {
    return Optional.ofNullable(document.toObject(entityClass))
        .map(entity -> mapper.toModel(document.getId(), entity))
        .orElseThrow();
  }

  @SneakyThrows
  private <V> V await(ApiFuture<V> future) {
    return future.get(DEFAULT_WAIT_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
  }
}

