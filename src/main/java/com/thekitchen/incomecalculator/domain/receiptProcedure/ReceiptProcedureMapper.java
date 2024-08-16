package com.thekitchen.incomecalculator.domain.receiptProcedure;

import com.thekitchen.incomecalculator.domain.receiptProcedure.api.model.ReceiptProcedure;
import com.thekitchen.incomecalculator.domain.receiptProcedure.api.rest.ReceiptProcedureView;
import com.thekitchen.incomecalculator.shared.mapper.ViewModelMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ReceiptProcedureMapper
    extends ViewModelMapper<ReceiptProcedureView, ReceiptProcedure> {

}
