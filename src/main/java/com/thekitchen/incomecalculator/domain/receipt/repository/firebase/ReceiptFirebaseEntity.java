package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import com.glebremniov.firebase.FirebaseEntity;
import com.google.cloud.Timestamp;
import com.thekitchen.incomecalculator.domain.receiptProcedure.repository.firebase.ReceiptProcedureFirebaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptFirebaseEntity implements FirebaseEntity {

  private String uid;
  private Timestamp date;
  private Timestamp dateCreated;
  private List<ReceiptProcedureFirebaseEntity> procedures;
}
