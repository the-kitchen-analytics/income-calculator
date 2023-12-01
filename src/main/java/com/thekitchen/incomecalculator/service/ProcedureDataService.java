package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.*;
import com.thekitchen.incomecalculator.repository.ProcedureRepository;
import com.thekitchen.incomecalculator.service.mapper.ProcedureRequestMapper;
import com.thekitchen.incomecalculator.service.model.Procedure;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProcedureDataService
    extends AbstractDataService<Procedure, ProcedureRequest, ProcedureView, String> {

  private final ProcedureRequestMapper mapper;
  private final ProcedureRepository repository;

  public ProcedureDataService(
      ProcedureRequestMapper mapper,
      ProcedureRepository repository) {
    super(mapper, repository);
    this.mapper = mapper;
    this.repository = repository;
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
}
