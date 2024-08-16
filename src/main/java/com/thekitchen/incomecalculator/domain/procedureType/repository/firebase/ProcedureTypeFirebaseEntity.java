package com.thekitchen.incomecalculator.domain.procedureType.repository.firebase;

import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProcedureTypeFirebaseEntity implements FirebaseEnum {

  MANICURE("manicure"),
  PEDICURE("pedicure"),
  SPA("spa"),
  BROWS("brows");

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
