package com.glebremniov.firebase;

/**
 * Interface for mapping between a model and a Firebase entity.
 *
 * @param <M> the model type
 * @param <E> the Firebase entity type
 */
public interface FirebaseEntityMapper<M, E extends FirebaseEntity> {

  /**
   * Converts a Firebase entity to a model.
   *
   * @param entity the Firebase entity
   * @return the model representation of the entity
   */
  M toModel(String id, E entity);

  /**
   * Converts a model to a Firebase entity.
   *
   * @param model the model to convert
   * @return the Firebase entity representation of the model
   */
  E toEntity(M model);

}
