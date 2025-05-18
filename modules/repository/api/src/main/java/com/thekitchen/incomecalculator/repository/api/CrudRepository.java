package com.thekitchen.incomecalculator.repository.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface for CRUD operations.
 *
 * @param <T>  the type of the entity
 * @param <ID> the type of the entity's identifier
 */
public interface CrudRepository<T, ID> {

  /**
   * Get all entities.
   *
   * @return a list of all entities
   */
  Collection<T> getAll();

  /**
   * Get an entity by its ID.
   *
   * @param id the ID of the entity
   * @return an optional containing the entity if found, or empty if not found
   */
  Optional<T> getById(ID id);

  /**
   * Save a new entity.
   *
   * @param model the entity to save
   * @return the saved entity
   */
  T save(T model);

  /**
   * Save multiple entities.
   *
   * @param models the entities to save
   * @return a list of saved entities
   */
  List<T> saveAll(Collection<T> models);

  /**
   * Update an existing entity.
   *
   * @param id    the ID of the entity to update
   * @param model the entity with updated values
   * @return the updated entity
   */
  T update(ID id, T model);

  /**
   * Delete an entity by its ID.
   *
   * @param id the ID of the entity to delete
   */
  void delete(ID id);

  /**
   * Delete multiple entities by their IDs.
   *
   * @param ids the IDs of the entities to delete
   */
  void deleteAll(Collection<ID> ids);

}
