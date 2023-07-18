package com.thekitchen.incomecalculator.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataService<REQUEST_DTO, DTO> {

  List<DTO> getAll();

  Optional<DTO> get(UUID id);

  DTO save(REQUEST_DTO request);

  List<DTO> saveAll(Collection<REQUEST_DTO> requests);

  DTO update(UUID id, REQUEST_DTO request);

  void delete(UUID id);

  void deleteAll(Collection<UUID> ids);
}
