package com.thekitchen.incomecalculator.firebase.entity;

import com.google.cloud.Timestamp;
import java.util.List;
import lombok.Data;

@Data
public class ReceiptFirebaseEntity implements FirebaseEntity {

  private String uid;
  private Timestamp date;
  private Timestamp dateCreated;
  private List<ReceiptProcedureFirebaseEntity> procedures;
}
