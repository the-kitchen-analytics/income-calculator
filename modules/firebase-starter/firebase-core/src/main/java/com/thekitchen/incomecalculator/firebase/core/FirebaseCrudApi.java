package com.thekitchen.incomecalculator.firebase.core;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Generic CRUD API for Firebase.
 *
 * @param <M> the type of the model
 */
public interface FirebaseCrudApi<M> {

  /**
   * Get all models.
   *
   * @return a collection of all models
   */
  Collection<M> getAll();

  /**
   * Get model by ID.
   *
   * @param id the ID of the model to get
   * @return an optional containing the model if found, or empty if not found
   */
  Optional<M> getById(String id);

  /**
   * Create a new model.
   *
   * @param model the model to create
   * @return the created model
   */
  M create(M model);

  /**
   * Update an existing model.
   *
   * @param id    the ID of the model to update
   * @param model the model with updated values
   * @return the updated model
   */
  M update(String id, M model);

  /**
   * Delete a model by ID.
   *
   * @param id the ID of the model to delete
   */
  void delete(String id);

  /**
   * Delete multiple models by their IDs.
   *
   * @param ids the IDs of the models to delete
   */
  void deleteAll(Set<String> ids);

}
