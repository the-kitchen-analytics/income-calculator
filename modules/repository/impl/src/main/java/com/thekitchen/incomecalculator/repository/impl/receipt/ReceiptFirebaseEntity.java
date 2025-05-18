package com.thekitchen.incomecalculator.repository.impl.receipt;

import com.google.cloud.Timestamp;
import com.thekitchen.incomecalculator.firebase.core.FirebaseEntity;
import com.thekitchen.incomecalculator.repository.impl.receiptProcedure.ReceiptProcedureFirebaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptFirebaseEntity implements FirebaseEntity {

  private String uid;
  private Timestamp date;
  private Timestamp dateCreated;
  private List<ReceiptProcedureFirebaseEntity> procedures;
}
