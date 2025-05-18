package com.thekitchen.incomecalculator.repository.impl.receipt;

import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.model.Receipt;
import com.thekitchen.incomecalculator.repository.api.ReceiptRepository;
import com.thekitchen.incomecalculator.repository.impl.GenericCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceiptRepositoryImpl extends GenericCrudRepository<Receipt> implements ReceiptRepository {

  public ReceiptRepositoryImpl(final FirebaseCrudApi<Receipt> receiptFirebaseCrudApi) {
    super(receiptFirebaseCrudApi);
  }

  @Override
  public List<Receipt> findAllByUserId(final String uid) {
    return getAll().stream()
        .filter(receipt -> receipt.uid().equals(uid))
        .toList();
  }
}
