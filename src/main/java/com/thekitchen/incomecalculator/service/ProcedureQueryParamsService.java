package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilterFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcedureQueryParamsService
    extends QueryParamsService<ProceduresQueryParams, ProcedureView> {

  public ProcedureQueryParamsService(
      QueryFilterFactory<ProceduresQueryParams, ProcedureView> filterFactory) {
    super(filterFactory);
  }
}
