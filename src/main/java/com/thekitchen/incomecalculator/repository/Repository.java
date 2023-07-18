package com.thekitchen.incomecalculator.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

  List<T> getAll();

  Optional<T> getById(ID id);

  T save(T model);

  T update(ID id, T model);

  void delete(ID id);

}
