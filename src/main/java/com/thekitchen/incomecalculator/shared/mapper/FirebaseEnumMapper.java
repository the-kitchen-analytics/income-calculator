package com.thekitchen.incomecalculator.shared.mapper;

import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEnum;

import java.util.Optional;

public interface FirebaseEnumMapper<M, E extends FirebaseEnum> {

  M toModel(String entity);

  M toModel(E entity);

  E toEntity(M entity);

  default String toEntityString(M model) {
    return Optional.ofNullable(toEntity(model))
        .map(FirebaseEnum::value)
        .orElse(null);
  }

}
