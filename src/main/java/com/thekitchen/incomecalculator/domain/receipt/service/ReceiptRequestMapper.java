package com.thekitchen.incomecalculator.domain.receipt.service;

import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.domain.receipt.api.rest.ReceiptRequest;
import com.thekitchen.incomecalculator.domain.receipt.api.rest.ReceiptView;
import com.thekitchen.incomecalculator.domain.receiptProcedure.ReceiptProcedureMapper;
import com.thekitchen.incomecalculator.shared.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(uses = ReceiptProcedureMapper.class)
public interface ReceiptRequestMapper extends RequestMapper<Receipt, ReceiptRequest, ReceiptView> {

}
