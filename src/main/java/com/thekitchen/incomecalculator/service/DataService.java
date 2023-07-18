package com.thekitchen.incomecalculator.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataService<DTO, REQUEST_DTO> {

  List<DTO> getAll();

  Optional<DTO> get(UUID id);

  DTO save(REQUEST_DTO request);

  DTO update(UUID id, REQUEST_DTO request);

  void delete(UUID id);
}
