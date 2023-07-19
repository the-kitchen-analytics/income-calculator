package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.repository.Repository;
import com.thekitchen.incomecalculator.service.mapper.RequestMapper;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDataService<MODEL, REQUEST, VIEW, ID>
    implements DataService<REQUEST, VIEW, ID> {

  private final RequestMapper<MODEL, REQUEST, VIEW> mapper;
  private final Repository<MODEL, ID> repository;

  @Override
  public List<VIEW> getAll() {
    return repository.getAll()
        .stream()
        .map(mapper::toView)
        .toList();
  }

  @Override
  public Optional<VIEW> get(ID id) {
    return repository.getById(id)
        .map(mapper::toView);
  }

  @Override
  public VIEW save(REQUEST request) {
    var saved = repository.save(mapper.toModel(request));
    return mapper.toView(saved);
  }

  @Override
  public List<VIEW> saveAll(Collection<REQUEST> requests) {
    return requests.stream()
        .map(mapper::toModel)
        .map(repository::save)
        .map(mapper::toView)
        .toList();
  }

  @Override
  public VIEW update(ID id, REQUEST request) {
    var updated = repository.update(id, mapper.toModel(request));
    return mapper.toView(updated);
  }

  @Override
  public void delete(ID id) {
    repository.delete(id);
  }

  @Override
  public void deleteAll(Collection<ID> ids) {
    repository.deleteAll(ids);
  }
}
