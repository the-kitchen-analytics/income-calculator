package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.repository.Repository;
import com.thekitchen.incomecalculator.service.mapper.RequestMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDataService<MODEL, REQUEST, VIEW> implements DataService<VIEW, REQUEST> {

  private final RequestMapper<MODEL, REQUEST, VIEW> mapper;
  private final Repository<MODEL, UUID> repository;

  @Override
  public List<VIEW> getAll() {
    return repository.getAll()
        .stream()
        .map(mapper::toView)
        .toList();
  }

  @Override
  public Optional<VIEW> get(UUID id) {
    return repository.getById(id)
        .map(mapper::toView);
  }

  @Override
  public VIEW save(REQUEST request) {
    var saved = repository.save(mapper.toModel(request));
    return mapper.toView(saved);
  }

  @Override
  public VIEW update(UUID id, REQUEST request) {
    var updated = repository.update(id, mapper.toModel(request));
    return mapper.toView(updated);
  }

  @Override
  public void delete(UUID id) {
    repository.delete(id);
  }
}
