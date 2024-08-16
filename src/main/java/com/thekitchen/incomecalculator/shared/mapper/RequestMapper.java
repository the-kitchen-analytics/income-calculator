package com.thekitchen.incomecalculator.shared.mapper;

public interface RequestMapper<M, R, V> extends ViewModelMapper<V, M> {

  M fromRequest(R request);

}
