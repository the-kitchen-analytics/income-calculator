package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.service.DataService;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public abstract class AbstractCrudController<REQUEST, RESPONSE, ID> {

  private final DataService<REQUEST, RESPONSE, ID> service;

  protected ResponseEntity<List<RESPONSE>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  protected ResponseEntity<RESPONSE> get(ID id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  protected ResponseEntity<RESPONSE> save(REQUEST request) {
    return ResponseEntity.ok(service.save(request));
  }

  protected ResponseEntity<List<RESPONSE>> saveAll(Collection<REQUEST> request) {
    return ResponseEntity.ok(service.saveAll(request));
  }

  protected ResponseEntity<RESPONSE> update(ID id, REQUEST request) {
    return ResponseEntity.ok(service.update(id, request));
  }

  protected ResponseEntity<Void> delete(ID id) {
    service.delete(id);
    return ResponseEntity.noContent()
        .build();
  }

  protected ResponseEntity<Void> deleteAll(Collection<ID> ids) {
    service.deleteAll(ids);
    return ResponseEntity.noContent()
        .build();
  }

}
