package com.thekitchen.incomecalculator.firebase.entity;

import lombok.Data;

@Data
public class UserFirebaseEntity implements FirebaseEntity {

  private String uid;
  private String email;
  private String name;
  private String displayName;
  private String workerCategory;
}
