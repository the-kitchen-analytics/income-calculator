package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import com.thekitchen.incomecalculator.domain.procedure.api.model.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedureType.repository.firebase.ProcedureTypeFirebaseEntityMapper;
import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.shared.mapper.DateTimeMapper;
import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateTimeMapper.class, ProcedureTypeFirebaseEntityMapper.class})
public interface ReceiptFirebaseEntityMapper extends FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> {


  @Mapping(target = "price", source = "priceBeforeTaxes")
  @Mapping(target = "workerIncome", source = "priceAfterTaxes")
  Procedure fromReceiptProcedure(ReceiptProcedureFirebaseEntity receiptProcedure);

  @Mapping(target = "priceBeforeTaxes", source = "price")
  @Mapping(target = "priceAfterTaxes", source = "workerIncome")
  ReceiptProcedureFirebaseEntity fromProcedure(Procedure procedure);
}
