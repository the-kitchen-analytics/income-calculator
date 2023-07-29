package com.thekitchen.incomecalculator.repository;

import com.thekitchen.incomecalculator.service.model.Receipt;
import java.util.List;

public interface ReceiptRepository extends Repository<Receipt, String> {

  List<Receipt> findAllByUserId(String uid);

}
