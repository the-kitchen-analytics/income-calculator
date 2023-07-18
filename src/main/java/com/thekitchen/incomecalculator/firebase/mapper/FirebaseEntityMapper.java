package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.firebase.entity.FirebaseEntity;

public interface FirebaseEntityMapper<M, E extends FirebaseEntity> {

  M toModel(String id, E entity);

  E toEntity(M model);

}
