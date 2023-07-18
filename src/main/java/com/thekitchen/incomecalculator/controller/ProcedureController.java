package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureResponse;
import com.thekitchen.incomecalculator.service.AbstractDataService;
import com.thekitchen.incomecalculator.service.model.Procedure;
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

  ProcedureController(AbstractDataService<Procedure, ProcedureRequest, ProcedureResponse> dataService) {
    super(dataService);
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

  @Override
  @PostMapping
  protected ResponseEntity<ProcedureResponse> save(@RequestBody ProcedureRequest request) {
    return super.save(request);
  }

  @Override
  @PostMapping("all")
  protected ResponseEntity<List<ProcedureResponse>> saveAll(@RequestBody Collection<ProcedureRequest> requestAll) {
    return super.saveAll(requestAll);
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
