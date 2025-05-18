package com.glebremniov.firebase.impl;

import com.glebremniov.firebase.FirebaseEntity;
import com.glebremniov.firebase.FirebaseRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * A generic repository for Firebase entities.
 * <p>
 * This class provides basic CRUD operations for Firebase entities.
 *
 * @param <E> the type of the entity
 */
public abstract class GenericFirebaseRepository<E extends FirebaseEntity>
    implements FirebaseRepository<E> {

  private static final Long DEFAULT_WAIT_INTERVAL_MILLIS = 600_000L;
  private static final String ID_MUST_NOT_BE_NULL = "ID must not be null";
  private static final String ENTITY_MUST_NOT_BE_NULL = "Entity must not be null";

  private final Firestore firestore;
  private final String collectionName;
  private final Class<E> entityClass;

  private static final Function<ApiFuture<DocumentSnapshot>, DocumentSnapshot> API_FUTURE_MAPPER =
      apiFuture -> {
        try {
          return apiFuture.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      };

  /**
   * Constructor for GenericFirebaseRepository.
   *
   * @param firestore      the Firestore instance
   * @param collectionName the name of the collection
   * @param entityClass    the class of the entity
   */
  protected GenericFirebaseRepository(
      final Firestore firestore,
      final String collectionName,
      final Class<E> entityClass
  ) {
    this.firestore = firestore;
    this.collectionName = collectionName;
    this.entityClass = entityClass;
  }

  private static <V> V await(final ApiFuture<V> future) {
    try {
      return future.get(DEFAULT_WAIT_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<E> getAll() {
    return Stream.of(getCollectionRef())
        .map(CollectionReference::get)
        .map(GenericFirebaseRepository::await)
        .map(QuerySnapshot::getDocuments)
        .flatMap(Collection::stream)
        .map(this::toModel)
        .toList();
  }

  @Override
  public Optional<E> getById(final String id) {
    Objects.requireNonNull(id, ID_MUST_NOT_BE_NULL);

    return Optional.of(getDocumentRef(id))
        .map(this::toModel);
  }

  @Override
  public E create(final E entity) {
    Objects.requireNonNull(entity, ENTITY_MUST_NOT_BE_NULL);

    return Optional.of(entity)
        .map(e -> getCollectionRef().add(e))
        .map(GenericFirebaseRepository::await)
        .map(this::toModel)
        .orElseThrow();
  }

  @Override
  public E update(final String id, final E entity) {
    Objects.requireNonNull(id, ID_MUST_NOT_BE_NULL);
    Objects.requireNonNull(entity, ENTITY_MUST_NOT_BE_NULL);

    return Optional.of(getDocumentRef(id))
        .map(documentRef -> documentRef.set(entity))
        .map(GenericFirebaseRepository::await)
        .map(WriteResult::getUpdateTime)
        .map(wr -> entity)
        .orElseThrow();
  }

  @Override
  public void delete(final String id) {
    Objects.requireNonNull(id, ID_MUST_NOT_BE_NULL);

    Optional.of(id)
        .map(this::getDocumentRef)
        .map(DocumentReference::delete)
        .map(GenericFirebaseRepository::await)
        .orElseThrow();
  }

  @Override
  public void deleteAll(final Set<String> ids) {
    Objects.requireNonNull(ids, "IDs must not be null");
    final var batch = firestore.batch();

    ids.stream()
        .map(this::getDocumentRef)
        .forEach(batch::delete);

    await(batch.commit());
  }

  private CollectionReference getCollectionRef() {
    return firestore.collection(collectionName);
  }

  private DocumentReference getDocumentRef(final String id) {
    return getCollectionRef().document(id);
  }

  private E toModel(final DocumentSnapshot document) {
    return Optional.ofNullable(document.toObject(entityClass))
        .orElseThrow();
  }

  private E toModel(final DocumentReference documentReference) {
    return Optional.of(documentReference)
        .map(DocumentReference::get)
        .map(API_FUTURE_MAPPER)
        .map(this::toModel)
        .orElseThrow();
  }
}
