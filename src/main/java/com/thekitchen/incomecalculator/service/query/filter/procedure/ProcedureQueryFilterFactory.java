package com.thekitchen.incomecalculator.service.query.filter.procedure;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import com.thekitchen.incomecalculator.service.query.filter.DefaultQueryFilter;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilter;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProcedureQueryFilterFactory
    extends QueryFilterFactory<ProceduresQueryParams, ProcedureView> {

  public ProcedureQueryFilterFactory(
      Set<QueryFilter<ProceduresQueryParams, ProcedureView>> queryFilters,
      DefaultQueryFilter<ProceduresQueryParams, ProcedureView> defaultQueryFilter) {
    super(queryFilters, defaultQueryFilter);
  }
}
