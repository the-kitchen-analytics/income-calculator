package com.thekitchen.incomecalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.controller.model.*;
import com.thekitchen.incomecalculator.repository.ProcedureRepository;
import com.thekitchen.incomecalculator.service.mapper.ProcedureRequestMapper;
import com.thekitchen.incomecalculator.service.model.Procedure;
import com.thekitchen.incomecalculator.util.JsonPatchUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProcedureDataService
    extends AbstractDataService<Procedure, ProcedureRequest, ProcedureView, String> {

  private final ProcedureRequestMapper mapper;
  private final ProcedureRepository repository;
  private final ObjectMapper objectMapper;

  public ProcedureDataService(
      ProcedureRequestMapper mapper,
      ProcedureRepository repository, ObjectMapper objectMapper) {
    super(mapper, repository);
    this.mapper = mapper;
    this.repository = repository;
    this.objectMapper = objectMapper;
  }

  public List<ProcedureView> create(CreateProcedureRequest request) {
    return mapper.fromCreateRequest(request)
        .stream()
        .map(this::save)
        .toList();
  }

  public List<ProcedureView> createAll(List<CreateProcedureRequest> requests) {
    return requests.stream()
        .map(mapper::fromCreateRequest)
        .flatMap(Collection::stream)
        .map(this::save)
        .toList();
  }

  public List<ProcedureView> findAllByWorkerCategory(WorkerCategory workerCategory) {
    return repository.findAllByWorkerCategory(mapper.toModel(workerCategory))
        .stream()
        .map(mapper::toView)
        .toList();
  }

  public List<ProcedureView> findAllByType(ProcedureType type) {
    return repository.findAllByType(mapper.toModel(type))
        .stream()
        .map(mapper::toView)
        .toList();
  }

  public List<ProcedureView> findAllByWorkerCategoryAndType(WorkerCategory workerCategory, ProcedureType type) {
    return repository.findAllByWorkerCategoryAndType(
            mapper.toModel(workerCategory),
            mapper.toModel(type))
        .stream()
        .map(mapper::toView)
        .toList();
  }

  @Override
  protected Procedure applyPatch(JsonMergePatch patch, Procedure model) {
    return JsonPatchUtils.applyPatch(objectMapper, patch, model, Procedure.class);
  }
}
