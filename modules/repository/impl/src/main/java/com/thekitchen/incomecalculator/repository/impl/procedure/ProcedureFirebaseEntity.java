package com.thekitchen.incomecalculator.repository.impl.procedure;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntity;
import lombok.Data;

@Data
public class ProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private String workerCategory;
  private Double price;
  private Double workerIncome;
}
