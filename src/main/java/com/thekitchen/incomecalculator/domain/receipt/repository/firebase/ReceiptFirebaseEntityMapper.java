package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import com.glebremniov.firebase.FirebaseEntityMapper;
import com.glebremniov.firebase.impl.FirebaseDateTimeConverter;
import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.domain.receiptProcedure.repository.firebase.ReceiptProcedureFirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
    FirebaseDateTimeConverter.class,
    ReceiptProcedureFirebaseEntityMapper.class
})
public interface ReceiptFirebaseEntityMapper extends FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> {
}
