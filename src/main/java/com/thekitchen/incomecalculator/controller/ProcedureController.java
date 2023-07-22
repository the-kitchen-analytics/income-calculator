package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.CreateProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureType;
import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.controller.model.WorkerCategory;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "procedures")
class ProcedureController extends AbstractCrudController<ProcedureRequest, ProcedureView, String> {

  private final ProcedureDataService service;

  ProcedureController(ProcedureDataService service) {
    super(service);
    this.service = service;
  }

  @GetMapping
  protected ResponseEntity<List<ProcedureView>> getAll(
      @RequestParam(required = false) WorkerCategory workerCategory,
      @RequestParam(required = false) ProcedureType typer) {
    return Optional.ofNullable(workerCategory)
        .map(service::findAllByWorkerCategory)
        .map(ResponseEntity::ok)
        .orElseGet(super::getAll);
  }

  @Override
  @GetMapping("{id}")
  protected ResponseEntity<ProcedureView> get(@PathVariable String id) {
    return super.get(id);
  }

  @PostMapping
  protected ResponseEntity<List<ProcedureView>> saveAll(@RequestBody List<CreateProcedureRequest> request) {
    var result = service.createAll(request);
    return ResponseEntity.ok(result);
  }

  @Override
  @PutMapping("{id}")
  protected ResponseEntity<ProcedureView> update(
      @PathVariable String id,
      @RequestBody ProcedureRequest request) {
    return super.update(id, request);
  }

  @Override
  @DeleteMapping("{id}")
  protected ResponseEntity<Void> delete(@PathVariable String id) {
    return super.delete(id);
  }

  @Override
  @DeleteMapping
  protected ResponseEntity<Void> deleteAll(@RequestBody Collection<String> ids) {
    return super.deleteAll(ids);
  }

}
