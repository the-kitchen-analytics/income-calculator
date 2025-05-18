package com.thekitchen.incomecalculator.domain.receiptProcedure.repository.firebase;

import com.glebremniov.firebase.FirebaseEntity;
import lombok.Data;

@Data
public class ReceiptProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private Double priceAfterTaxes;
  private Double priceBeforeTaxes;
}
