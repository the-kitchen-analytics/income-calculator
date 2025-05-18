package com.thekitchen.incomecalculator.repository.impl.receiptProcedure;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.model.ReceiptProcedure;
import com.thekitchen.incomecalculator.repository.impl.procedureType.ProcedureTypeFirebaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ProcedureTypeFirebaseEntityMapper.class})
public interface ReceiptProcedureFirebaseEntityMapper
    extends FirebaseEntityMapper<ReceiptProcedure, ReceiptProcedureFirebaseEntity> {

  String PRICE_MODEL = "price";
  String PRICE_ENTITY = "priceBeforeTaxes";
  String WORKER_INCOME_MODEL = "workerIncome";
  String WORKER_INCOME_ENTITY = "priceAfterTaxes";

  @Mapping(target = PRICE_MODEL, source = PRICE_ENTITY)
  @Mapping(target = WORKER_INCOME_MODEL, source = WORKER_INCOME_ENTITY)
  ReceiptProcedure toModel(ReceiptProcedureFirebaseEntity receiptProcedure);

  @Mapping(target = PRICE_ENTITY, source = PRICE_MODEL)
  @Mapping(target = WORKER_INCOME_ENTITY, source = WORKER_INCOME_MODEL)
  ReceiptProcedureFirebaseEntity toEntity(ReceiptProcedure procedure);

}
