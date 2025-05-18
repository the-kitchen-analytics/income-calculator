package com.thekitchen.incomecalculator.repository.impl;

import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.repository.api.CrudRepository;

import java.util.*;

public class GenericCrudRepository<M> implements CrudRepository<M, String> {

  private final FirebaseCrudApi<M> firebaseCrudApi;

  public GenericCrudRepository(FirebaseCrudApi<M> firebaseCrudApi) {
    this.firebaseCrudApi = firebaseCrudApi;
  }

  @Override
  public Collection<M> getAll() {
    return firebaseCrudApi.getAll();
  }

  @Override
  public Optional<M> getById(final String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    return firebaseCrudApi.getById(id);
  }

  @Override
  public M save(final M entity) {
    Objects.requireNonNull(entity, "Entity cannot be null");
    return firebaseCrudApi.create(entity);
  }

  @Override
  public List<M> saveAll(final Collection<M> entities) {
    Objects.requireNonNull(entities, "Entities cannot be null");
    return entities.stream()
        .map(this::save)
        .toList();
  }

  @Override
  public M update(final String id, final M entity) {
    Objects.requireNonNull(id, "ID cannot be null");
    return firebaseCrudApi.update(id, entity);
  }

  @Override
  public void delete(final String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    firebaseCrudApi.delete(id);
  }

  @Override
  public void deleteAll(final Collection<String> ids) {
    Objects.requireNonNull(ids, "IDs cannot be null");
    firebaseCrudApi.deleteAll(Set.copyOf(ids));
  }

}
