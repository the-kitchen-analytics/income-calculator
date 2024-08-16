package com.thekitchen.incomecalculator.domain.receipt.repository;

import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.shared.repository.Repository;

import java.util.List;

public interface ReceiptRepository extends Repository<Receipt, String> {

  List<Receipt> findAllByUserId(String uid);

}
