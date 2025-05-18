package com.thekitchen.incomecalculator.firebase.core;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Generic interface for Firebase repositories.
 *
 * @param <E> the entity type, which must extend {@link FirebaseEntity}
 */
public interface FirebaseRepository<E extends FirebaseEntity> {

  /**
   * Retrieves all entities from the repository.
   *
   * @return a collection of FirebaseDocument objects containing all entities
   */
  Collection<FirebaseDocument<E>> getAll();

  /**
   * Retrieves an entity by its ID.
   *
   * @param id the unique identifier of the entity
   * @return an Optional containing the FirebaseDocument of the entity if found, or empty if not found
   */
  Optional<FirebaseDocument<E>> getById(String id);

  /**
   * Creates a new entity in the repository.
   *
   * @param entity the entity to be created
   * @return the FirebaseDocument of the created entity
   */
  FirebaseDocument<E> create(E entity);

  /**
   * Updates an existing entity in the repository.
   *
   * @param id     the unique identifier of the entity to update
   * @param entity the updated entity data
   * @return the FirebaseDocument of the updated entity
   */
  FirebaseDocument<E> update(String id, E entity);

  /**
   * Deletes an entity from the repository.
   *
   * @param id the unique identifier of the entity to delete
   */
  void delete(String id);

  /**
   * Deletes multiple entities from the repository.
   *
   * @param ids a set of unique identifiers of the entities to delete
   */
  void deleteAll(Set<String> ids);

}
