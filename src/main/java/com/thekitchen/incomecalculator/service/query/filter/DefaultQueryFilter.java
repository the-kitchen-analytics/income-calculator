package com.thekitchen.incomecalculator.service.query.filter;

public interface DefaultQueryFilter<P, V> extends QueryFilter<P, V> {

  @Override
  default boolean isApplicable(P params) {
    return false;
  }
}
