package com.thekitchen.incomecalculator.controller.procedure;

import com.thekitchen.incomecalculator.controller.AbstractCrudController;
import com.thekitchen.incomecalculator.controller.user.WorkerCategory;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
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

  ProcedureController(ProcedureDataService service) {
    super(service);
    this.service = service;
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
}
