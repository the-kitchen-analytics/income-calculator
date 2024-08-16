package com.thekitchen.incomecalculator.domain.user.repository.firebase;

import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntity;
import lombok.Data;

@Data
public class UserFirebaseEntity implements FirebaseEntity {

  private String uid;
  private String email;
  private String name;
  private String displayName;
  private String workerCategory;
}
