package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.firebase.entity.ReceiptFirebaseEntity;
import com.thekitchen.incomecalculator.firebase.entity.ReceiptProcedureFirebaseEntity;
import com.thekitchen.incomecalculator.service.model.Procedure;
import com.thekitchen.incomecalculator.service.model.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateTimeMapper.class, ProcedureTypeMapper.class})
public interface ReceiptFirebaseEntityMapper extends FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> {


  @Mapping(target = "price", source = "priceBeforeTaxes")
  @Mapping(target = "workerIncome", source = "priceAfterTaxes")
  Procedure fromReceiptProcedure(ReceiptProcedureFirebaseEntity receiptProcedure);

  @Mapping(target = "priceBeforeTaxes", source = "price")
  @Mapping(target = "priceAfterTaxes", source = "workerIncome")
  ReceiptProcedureFirebaseEntity fromProcedure(Procedure procedure);
}
