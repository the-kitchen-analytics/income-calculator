package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.CreateProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureResponse;
import com.thekitchen.incomecalculator.repository.Repository;
import com.thekitchen.incomecalculator.service.mapper.ProcedureRequestMapper;
import com.thekitchen.incomecalculator.service.model.Procedure;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProcedureDataService
    extends AbstractDataService<Procedure, ProcedureRequest, ProcedureResponse> {

  private final ProcedureRequestMapper mapper;

  public ProcedureDataService(
      ProcedureRequestMapper mapper,
      Repository<Procedure, UUID> repository) {
    super(mapper, repository);
    this.mapper = mapper;
  }

  public List<ProcedureResponse> create(CreateProcedureRequest request) {
    return mapper.fromCreateRequest(request)
        .stream()
        .map(this::save)
        .toList();
  }

  public List<ProcedureResponse> createAll(List<CreateProcedureRequest> requests) {
    return requests.stream()
        .map(mapper::fromCreateRequest)
        .flatMap(Collection::stream)
        .map(this::save)
        .toList();
  }

}
