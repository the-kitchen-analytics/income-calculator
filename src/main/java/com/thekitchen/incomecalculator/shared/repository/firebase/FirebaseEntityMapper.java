package com.thekitchen.incomecalculator.shared.repository.firebase;

public interface FirebaseEntityMapper<M, E extends FirebaseEntity> {

  M toModel(String id, E entity);

  E toEntity(M model);

}
