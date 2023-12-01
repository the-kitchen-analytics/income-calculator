package com.thekitchen.incomecalculator.service.query.filter;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;

import java.util.List;

public interface QueryFilter<P, V> {

  List<V> filter(P params);

  boolean isApplicable(P params);

}
