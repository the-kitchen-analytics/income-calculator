package com.thekitchen.incomecalculator.firebase.entity;

import com.google.cloud.Timestamp;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptFirebaseEntity implements FirebaseEntity {

  private String uid;
  private Timestamp date;
  private Timestamp dateCreated;
  private List<ReceiptProcedureFirebaseEntity> procedures;
}
