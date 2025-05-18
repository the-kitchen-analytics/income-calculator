package com.thekitchen.incomecalculator.domain.procedure.repository.firebase;

import com.glebremniov.firebase.FirebaseEntity;
import lombok.Data;

@Data
public class ProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private String workerCategory;
  private Double price;
  private Double workerIncome;
}
