package com.thekitchen.incomecalculator.repository.impl.receipt;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.firebase.core.impl.FirebaseDateTimeConverter;
import com.thekitchen.incomecalculator.model.Receipt;
import com.thekitchen.incomecalculator.repository.impl.receiptProcedure.ReceiptProcedureFirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {
    FirebaseDateTimeConverter.class,
    ReceiptProcedureFirebaseEntityMapper.class
})
public interface ReceiptFirebaseEntityMapper extends FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> {
}
