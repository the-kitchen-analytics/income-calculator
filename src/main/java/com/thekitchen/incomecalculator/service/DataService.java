package com.thekitchen.incomecalculator.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DataService<REQUEST_DTO, DTO, ID> {

  List<DTO> getAll();

  Optional<DTO> get(ID id);

  DTO save(REQUEST_DTO request);

  List<DTO> saveAll(Collection<REQUEST_DTO> requests);

  DTO update(ID id, REQUEST_DTO request);

  void delete(ID id);

  void deleteAll(Collection<ID> ids);
}
