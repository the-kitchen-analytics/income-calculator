package com.thekitchen.incomecalculator.service.mapper;

public interface RequestMapper<MODEL, REQUEST, VIEW> {

  MODEL toModel(REQUEST request);

  VIEW toView(MODEL model);

}
