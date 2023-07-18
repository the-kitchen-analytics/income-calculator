package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureResponse;
import com.thekitchen.incomecalculator.repository.Repository;
import com.thekitchen.incomecalculator.service.mapper.RequestMapper;
import com.thekitchen.incomecalculator.service.model.Procedure;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProcedureDataService
    extends AbstractDataService<Procedure, ProcedureRequest, ProcedureResponse> {

  public ProcedureDataService(
      RequestMapper<Procedure, ProcedureRequest, ProcedureResponse> mapper,
      Repository<Procedure, UUID> repository) {
    super(mapper, repository);
  }
}
