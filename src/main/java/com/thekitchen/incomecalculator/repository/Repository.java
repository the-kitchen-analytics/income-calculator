package com.thekitchen.incomecalculator.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

  List<T> getAll();

  Optional<T> getById(ID id);

  T save(T model);

  List<T> saveAll(Collection<T> models);

  T update(ID id, T model);

  void delete(ID id);

  void deleteAll(Collection<ID> ids);

}
