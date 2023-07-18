package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.service.AbstractDataService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public abstract class AbstractCrudController<REQUEST, RESPONSE> {

  private final AbstractDataService<?, REQUEST, RESPONSE> service;

  protected ResponseEntity<List<RESPONSE>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  protected ResponseEntity<RESPONSE> get(UUID id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  protected ResponseEntity<RESPONSE> save(REQUEST request) {
    return ResponseEntity.ok(service.save(request));
  }

  protected ResponseEntity<RESPONSE> update(UUID id, REQUEST request) {
    return ResponseEntity.ok(service.update(id, request));
  }

  protected ResponseEntity<Void> delete(UUID id) {
    service.delete(id);
    return ResponseEntity.noContent()
        .build();
  }

}
