package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.*;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
import com.thekitchen.incomecalculator.service.QueryParamsService;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "procedures")
class ProcedureController extends AbstractCrudController<ProcedureRequest, ProcedureView, String> {

  private final ProcedureDataService service;
  private final QueryParamsService<ProceduresQueryParams, ProcedureView> queryParamsService;

  ProcedureController(ProcedureDataService service,
                      QueryParamsService<ProceduresQueryParams, ProcedureView> queryParamsService) {
    super(service);
    this.service = service;
    this.queryParamsService = queryParamsService;
  }

  @GetMapping
  protected ResponseEntity<List<ProcedureView>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping(params = "workerCategory")
  protected ResponseEntity<List<ProcedureView>> getAllByWorkerCategory(@RequestParam WorkerCategory workerCategory) {
    return ResponseEntity.ok(service.findAllByWorkerCategory(workerCategory));
  }

  @GetMapping(params = "type")
  protected ResponseEntity<List<ProcedureView>> getAllByProcedureType(@RequestParam ProcedureType type) {
    return ResponseEntity.ok(service.findAllByType(type));
  }

  @GetMapping(params = {"workerCategory", "type"})
  protected ResponseEntity<List<ProcedureView>> getAllByWorkerCategoryAndProcedureType(
      @RequestParam WorkerCategory workerCategory,
      @RequestParam ProcedureType type) {
    return ResponseEntity.ok(service.findAllByWorkerCategoryAndType(workerCategory, type));
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
