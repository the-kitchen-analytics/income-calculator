package com.thekitchen.incomecalculator.domain.procedure.api.rest;

import com.thekitchen.incomecalculator.domain.procedure.service.ProcedureDataService;
import com.thekitchen.incomecalculator.domain.procedureType.ProcedureTypeMapper;
import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import com.thekitchen.incomecalculator.domain.workerCategory.WorkerCategoryMapper;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;
import com.thekitchen.incomecalculator.shared.api.rest.AbstractCrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "procedures")
class ProcedureController extends AbstractCrudController<ProcedureRequest, ProcedureView, String> {

  private final ProcedureDataService service;
  private final WorkerCategoryMapper workerCategoryMapper;
  private final ProcedureTypeMapper procedureTypeMapper;

  ProcedureController(ProcedureDataService service, WorkerCategoryMapper workerCategoryMapper, ProcedureTypeMapper procedureTypeMapper) {
    super(service);
    this.service = service;
    this.workerCategoryMapper = workerCategoryMapper;
    this.procedureTypeMapper = procedureTypeMapper;
  }

  @GetMapping(params = "workerCategory")
  protected ResponseEntity<List<ProcedureView>> getAllByWorkerCategory(
      @RequestParam WorkerCategoryView workerCategory) {
    var result = service.findAllByWorkerCategory(workerCategoryMapper.toModel(workerCategory));

    return ResponseEntity.ok(result);
  }

  @GetMapping(params = "type")
  protected ResponseEntity<List<ProcedureView>> getAllByProcedureType(
      @RequestParam ProcedureTypeView type) {
    var result = service.findAllByType(procedureTypeMapper.toModel(type));
    return ResponseEntity.ok(result);
  }

  @GetMapping(params = {"workerCategory", "type"})
  protected ResponseEntity<List<ProcedureView>> getAllByWorkerCategoryAndProcedureType(
      @RequestParam WorkerCategoryView workerCategory,
      @RequestParam ProcedureTypeView type) {
    var result = service.findAllByWorkerCategoryAndType(
        workerCategoryMapper.toModel(workerCategory),
        procedureTypeMapper.toModel(type)
    );

    return ResponseEntity.ok(result);
  }
}
