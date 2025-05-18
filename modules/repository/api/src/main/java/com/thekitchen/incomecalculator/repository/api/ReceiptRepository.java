package com.thekitchen.incomecalculator.repository.api;

import com.thekitchen.incomecalculator.model.Receipt;

import java.util.List;

public interface ReceiptRepository extends CrudRepository<Receipt, String> {

  List<Receipt> findAllByUserId(String uid);

}
