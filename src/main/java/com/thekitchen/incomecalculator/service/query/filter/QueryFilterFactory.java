package com.thekitchen.incomecalculator.service.query.filter;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public abstract class QueryFilterFactory<P, V> {

  private final Set<QueryFilter<P, V>> queryFilters;
  private final DefaultQueryFilter<P, V> defaultQueryFilter;

  public QueryFilter<P, V> get(P queryParams) {
    return queryFilters.stream()
        .filter(queryFilter -> queryFilter.isApplicable(queryParams))
        .findFirst()
        .orElse(defaultQueryFilter);
  }

}
