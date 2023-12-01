package com.thekitchen.incomecalculator.service.query.filter.procedure;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.ProcedureDataService;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class WorkerCategoryProcedureTypeQueryFilter
    implements QueryFilter<ProceduresQueryParams, ProcedureView> {

  private final ProcedureDataService service;

  @Override
  public List<ProcedureView> filter(ProceduresQueryParams params) {
    return service.findAllByWorkerCategoryAndType(
        params.workerCategory().orElseThrow(),
        params.type().orElseThrow());
  }

  @Override
  public boolean isApplicable(ProceduresQueryParams params) {
    return Stream.of(params.workerCategory(), params.type())
        .allMatch(Optional::isPresent);
  }
}
