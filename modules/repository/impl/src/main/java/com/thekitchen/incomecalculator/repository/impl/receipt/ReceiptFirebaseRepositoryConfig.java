package com.thekitchen.incomecalculator.repository.impl.receipt;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.FirebaseRepository;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseRepository;
import com.thekitchen.incomecalculator.model.Receipt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiptFirebaseRepositoryConfig {

  @Bean
  FirebaseRepository<ReceiptFirebaseEntity> receiptFirebaseRepository(
      final Firestore firestore
  ) {
    return new GenericFirebaseRepository<>(
        firestore,
        "receipts",
        ReceiptFirebaseEntity.class
    );
  }

  @Bean
  FirebaseCrudApi<Receipt> receiptFirebaseCrudApi(
      final FirebaseRepository<ReceiptFirebaseEntity> receiptFirebaseRepository,
      final ReceiptFirebaseEntityMapper receiptFirebaseEntityMapper
  ) {
    return new GenericFirebaseCrudApi<>(receiptFirebaseEntityMapper, receiptFirebaseRepository);
  }

}
