package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.CreateProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureResponse;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "procedures")
class ProcedureController extends AbstractCrudController<ProcedureRequest, ProcedureResponse> {

  private final ProcedureDataService service;

  ProcedureController(ProcedureDataService service) {
    super(service);
    this.service = service;
  }

  @Override
  @GetMapping
  protected ResponseEntity<List<ProcedureResponse>> getAll() {
    return super.getAll();
  }

  @Override
  @GetMapping("{id}")
  protected ResponseEntity<ProcedureResponse> get(@PathVariable UUID id) {
    return super.get(id);
  }

  @PostMapping
  protected ResponseEntity<List<ProcedureResponse>> saveAll(@RequestBody List<CreateProcedureRequest> request) {
    var result = service.createAll(request);
    return ResponseEntity.ok(result);
  }

  @Override
  @PutMapping("{id}")
  protected ResponseEntity<ProcedureResponse> update(
      @PathVariable UUID id,
      @RequestBody ProcedureRequest request) {
    return super.update(id, request);
  }

  @Override
  @DeleteMapping("{id}")
  protected ResponseEntity<Void> delete(@PathVariable UUID id) {
    return super.delete(id);
  }

  @Override
  @DeleteMapping
  protected ResponseEntity<Void> deleteAll(@RequestBody Collection<UUID> ids) {
    return super.deleteAll(ids);
  }

}
