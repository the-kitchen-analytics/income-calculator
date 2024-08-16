package com.thekitchen.incomecalculator.domain.receipt.repository.firebase;

import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.domain.receiptProcedure.repository.firebase.ReceiptProcedureFirebaseEntityMapper;
import com.thekitchen.incomecalculator.shared.repository.firebase.DateTimeMapper;
import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
    DateTimeMapper.class,
    ReceiptProcedureFirebaseEntityMapper.class
})
public interface ReceiptFirebaseEntityMapper extends FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> {
}
