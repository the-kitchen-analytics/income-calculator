package com.thekitchen.incomecalculator.domain.workerCategory.repository.firebase;

import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WorkerCategoryFirebaseEntity implements FirebaseEnum {

  MASTER("master"),
  TOP_MASTER("top-master"),
  INSTRUCTOR("instructor");

  private final String value;

  @Override
  public String value() {
    return this.value;
  }

  @Override
  public String toString() {
    return this.value();
  }

}
