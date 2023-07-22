package com.thekitchen.incomecalculator.firebase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFirebaseEntity implements FirebaseEntity {

  private String uid;
  private String email;
  private String name;
  private String displayName;
  private String workerCategory;
}
