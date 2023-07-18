package com.thekitchen.incomecalculator.firebase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private String workerCategory;
  private Double price;
  private Double workerIncome;
}
