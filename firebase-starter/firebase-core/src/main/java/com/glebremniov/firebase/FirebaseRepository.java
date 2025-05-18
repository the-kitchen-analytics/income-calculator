package com.glebremniov.firebase;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Generic interface for Firebase repositories.
 *
 * @param <E> the entity type
 */
public interface FirebaseRepository<E extends FirebaseEntity> {

  /**
   * Retrieves all entities from the repository.
   *
   * @return a list of all entities
   */
  Collection<E> getAll();

  /**
   * Retrieves an entity by its ID.
   *
   * @param id the ID of the entity
   * @return an Optional containing the entity if found, or empty if not found
   */
  Optional<E> getById(String id);

  /**
   * Creates a new entity in the repository.
   *
   * @param entity the entity to create
   * @return the created entity
   */
  E create(E entity);

  /**
   * Updates an existing entity in the repository.
   *
   * @param id     the ID of the entity to update
   * @param entity the updated entity
   * @return the updated entity
   */
  E update(String id, E entity);

  /**
   * Deletes an entity from the repository.
   *
   * @param id the ID of the entity to delete
   */
  void delete(String id);

  /**
   * Deletes multiple entities from the repository.
   *
   * @param ids the IDs of the entities to delete
   */
  void deleteAll(Set<String> ids);

}
