package com.thekitchen.incomecalculator.repository.impl.receiptProcedure;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntity;
import lombok.Data;

@Data
public class ReceiptProcedureFirebaseEntity implements FirebaseEntity {

  private String name;
  private String type;
  private Double priceAfterTaxes;
  private Double priceBeforeTaxes;
}
