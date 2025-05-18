package com.thekitchen.incomecalculator.firebase.core.impl;

import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.FirebaseEntity;
import com.thekitchen.incomecalculator.firebase.core.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.firebase.core.FirebaseRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Generic implementation of Firebase CRUD API.
 *
 * @param <M> the model type
 * @param <E> the entity type
 */
public class GenericFirebaseCrudApi<M, E extends FirebaseEntity> implements FirebaseCrudApi<M> {

  private final FirebaseEntityMapper<M, E> mapper;
  private final FirebaseRepository<E> repository;

  public GenericFirebaseCrudApi(
      final FirebaseEntityMapper<M, E> mapper,
      final FirebaseRepository<E> repository
  ) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public Collection<M> getAll() {
    return repository.getAll()
        .stream()
        .map(mapper::toModel).toList();
  }

  @Override
  public Optional<M> getById(final String id) {
    Objects.requireNonNull(id);
    return repository.getById(id)
        .map(mapper::toModel);
  }

  @Override
  public M create(final M model) {
    Objects.requireNonNull(model);
    final var result = repository.create(mapper.toEntity(model));
    return mapper.toModel(result);
  }

  @Override
  public M update(final String id, final M model) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(model);
    final var entity = mapper.toEntity(model);
    final var result = repository.update(id, entity);
    return mapper.toModel(result);
  }

  @Override
  public void delete(final String id) {
    Objects.requireNonNull(id);
    repository.delete(id);
  }

  @Override
  public void deleteAll(final Set<String> ids) {
    Objects.requireNonNull(ids);
    repository.deleteAll(ids);
  }
}
