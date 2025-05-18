package com.thekitchen.incomecalculator.firebase.core;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.Optional;

/**
 * Represents a Firebase document containing an entity.
 *
 * @param <E> the type of the entity
 */
public record FirebaseDocument<E extends FirebaseEntity>(String id, E entity) {

  /**
   * Creates a new instance of FirebaseDocument from a DocumentSnapshot.
   *
   * @param snapshot    the DocumentSnapshot to convert
   * @param entityClass the class of the entity
   * @param <E>         the type of the entity
   * @return a new instance of FirebaseDocument
   */
  public static <E extends FirebaseEntity> FirebaseDocument<E> ofSnapshot(
      final DocumentSnapshot snapshot,
      final Class<E> entityClass) {

    return Optional.ofNullable(snapshot)
        .filter(DocumentSnapshot::exists)
        .map(s -> new FirebaseDocument<>(s.getId(), s.toObject(entityClass)))
        .orElseThrow();
  }

}
