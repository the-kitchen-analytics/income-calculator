package com.thekitchen.incomecalculator.service.query.filter.procedure;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import com.thekitchen.incomecalculator.service.query.filter.DefaultQueryFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultProcedureQueryFilter
    implements DefaultQueryFilter<ProceduresQueryParams, ProcedureView> {

  private final ProcedureDataService service;

  @Override
  public List<ProcedureView> filter(ProceduresQueryParams params) {
    return service.getAll();
  }

}
