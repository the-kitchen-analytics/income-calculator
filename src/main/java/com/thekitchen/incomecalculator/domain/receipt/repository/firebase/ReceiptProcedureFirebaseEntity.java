package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import lombok.Data;

@Data
public class ReceiptProcedureFirebaseEntity {

  private String name;
  private String type;
  private Double priceAfterTaxes;
  private Double priceBeforeTaxes;
}
