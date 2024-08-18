package com.thekitchen.incomecalculator.shared.api.rest;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.shared.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public abstract class AbstractCrudController<REQUEST, RESPONSE, ID> {

  private final DataService<REQUEST, RESPONSE, ID> service;

  @GetMapping
  protected ResponseEntity<List<RESPONSE>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping(value = "{id}")
  protected ResponseEntity<RESPONSE> get(@PathVariable ID id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(this::notFound);
  }

  @PostMapping
  protected ResponseEntity<RESPONSE> save(@RequestBody REQUEST request) {
    return ResponseEntity.ok(service.save(request));
  }

  @PostMapping(value = "all")
  protected ResponseEntity<List<RESPONSE>> saveAll(@RequestBody Collection<REQUEST> request) {
    return ResponseEntity.ok(service.saveAll(request));
  }

  @PutMapping(value = "{id}")
  protected ResponseEntity<RESPONSE> update(@PathVariable ID id, @RequestBody REQUEST request) {
    try {
      return ResponseEntity.ok(service.update(id, request));
    } catch (NoSuchElementException e) {
      return notFound();
    }
  }

  @PatchMapping(value = "{id}")
  protected ResponseEntity<RESPONSE> patch(@PathVariable ID id, @RequestBody JsonMergePatch patch) {
    try {
      return ResponseEntity.ok(service.patch(id, patch));
    } catch (NoSuchElementException e) {
      return notFound();
    }
  }

  @DeleteMapping(value = "{id}")
  protected ResponseEntity<Void> delete(@PathVariable ID id) {
    service.delete(id);
    return ResponseEntity.noContent()
        .build();
  }

  @DeleteMapping
  protected ResponseEntity<Void> deleteAll(Collection<ID> ids) {
    service.deleteAll(ids);
    return ResponseEntity.noContent()
        .build();
  }

  private ResponseEntity<RESPONSE> notFound() {
    return ResponseEntity.notFound().build();
  }
}
