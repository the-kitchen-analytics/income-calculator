package com.thekitchen.incomecalculator.shared.mapper;

public interface ViewModelMapper<V, M> {

  V toView(M model);

  M toModel(V view);

}
