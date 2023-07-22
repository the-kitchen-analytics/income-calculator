package com.thekitchen.incomecalculator.service.mapper;

import com.thekitchen.incomecalculator.controller.model.ReceiptRequest;
import com.thekitchen.incomecalculator.controller.model.ReceiptView;
import com.thekitchen.incomecalculator.service.model.Receipt;
import org.mapstruct.Mapper;

@Mapper
public interface ReceiptMapper extends RequestMapper<Receipt, ReceiptRequest, ReceiptView> {

}
