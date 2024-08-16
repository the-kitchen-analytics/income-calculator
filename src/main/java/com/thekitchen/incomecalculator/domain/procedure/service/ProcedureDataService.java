package com.thekitchen.incomecalculator.domain.procedure.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.domain.procedure.api.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.CreateProcedureRequest;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.PriceDetails;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.ProcedureRequest;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.ProcedureView;
import com.thekitchen.incomecalculator.domain.procedure.repository.ProcedureRepository;
import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.shared.service.AbstractDataService;
import com.thekitchen.incomecalculator.shared.util.JsonPatchUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProcedureDataService
    extends AbstractDataService<Procedure, ProcedureRequest, ProcedureView, String> {

  private final ProcedureRequestMapper mapper;
  private final ProcedureRepository repository;
  private final ObjectMapper objectMapper;
  private final WorkerIncomeCalculationService calculationService;

  public ProcedureDataService(
      ProcedureRequestMapper mapper,
      ProcedureRepository repository,
      ObjectMapper objectMapper,
      WorkerIncomeCalculationService calculationService
  ) {
    super(mapper, repository);
    this.mapper = mapper;
    this.repository = repository;
    this.objectMapper = objectMapper;
    this.calculationService = calculationService;
  }

  public List<ProcedureView> create(CreateProcedureRequest request) {
    return request.prices().stream()
        .map(details -> fromDetails(request, details))
        .map(this::save)
        .toList();
  }

  public List<ProcedureView> createAll(List<CreateProcedureRequest> requests) {
    return requests.stream()
        .map(this::create)
        .flatMap(Collection::stream)
        .toList();
  }

  public List<ProcedureView> findAllByWorkerCategory(WorkerCategory workerCategory) {
    return repository.findAllByWorkerCategory(workerCategory)
        .stream()
        .map(mapper::toView)
        .toList();
  }

  public List<ProcedureView> findAllByType(ProcedureType type) {
    return repository.findAllByType(type)
        .stream()
        .map(mapper::toView)
        .toList();
  }

  public List<ProcedureView> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type) {
    return repository.findAllByWorkerCategoryAndType(workerCategory, type)
        .stream()
        .map(mapper::toView)
        .toList();
  }

  @Override
  protected Procedure applyPatch(JsonMergePatch patch, Procedure model) {
    return JsonPatchUtils.applyPatch(objectMapper, patch, model, Procedure.class);
  }

  private ProcedureRequest fromDetails(CreateProcedureRequest request, PriceDetails details) {
    var workerIncome = calculationService.calculateWorkerIncome(details);
    return ProcedureRequest.fromDetails(
        request.name(),
        request.type(),
        details,
        workerIncome
    );
  }
}
