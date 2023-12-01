package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.service.query.filter.QueryFilterFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class QueryParamsService<P, V> {

  private final QueryFilterFactory<P, V> filterFactory;

  public List<V> get(P queryParams) {
    return filterFactory.get(queryParams)
        .filter(queryParams);
  }

}
