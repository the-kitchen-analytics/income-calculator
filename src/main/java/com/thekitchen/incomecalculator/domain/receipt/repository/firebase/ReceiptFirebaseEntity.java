package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import com.google.cloud.Timestamp;
import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptFirebaseEntity implements FirebaseEntity {

  private String uid;
  private Timestamp date;
  private Timestamp dateCreated;
  private List<ReceiptProcedureFirebaseEntity> procedures;
}
