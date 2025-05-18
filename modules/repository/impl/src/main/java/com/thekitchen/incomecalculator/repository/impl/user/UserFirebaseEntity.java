package com.thekitchen.incomecalculator.repository.impl.user;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntity;
import lombok.Data;

@Data
public class UserFirebaseEntity implements FirebaseEntity {

  private String uid;
  private String email;
  private String name;
  private String displayName;
  private String workerCategory;
}
