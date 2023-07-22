package com.thekitchen.incomecalculator.firebase.entity;

import lombok.Data;

@Data
public class ProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private String workerCategory;
  private Double price;
  private Double workerIncome;
}
