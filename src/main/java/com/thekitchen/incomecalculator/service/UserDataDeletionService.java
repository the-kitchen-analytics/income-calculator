package com.thekitchen.incomecalculator.service;

import com.google.firebase.auth.FirebaseAuth;
import com.thekitchen.incomecalculator.repository.ReceiptRepository;
import com.thekitchen.incomecalculator.service.model.Receipt;
import java.util.List;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDataDeletionService {

  private final ReceiptRepository receiptRepository;
  private final List<Consumer<String>> deleteConsumers = List.of(
      this::deleteReceipts,
      this::deleteAuth
  );

  public void deleteByUid(String uid) {
    log.info("Delete user data by uid: {}", uid);
    deleteConsumers.forEach(consumer -> consumer.accept(uid));
  }

  private void deleteReceipts(String uid) {
    var receiptIds = receiptRepository.findAllByUserId(uid)
        .stream()
        .map(Receipt::id)
        .toList();

    log.info("Delete related receipts for uid: {} count: {}", uid, receiptIds.size());
    receiptRepository.deleteAll(receiptIds);
  }

  @SneakyThrows
  private void deleteAuth(String uid) {
    log.info("Delete firebase auth receipts: {}", uid);
    FirebaseAuth.getInstance().deleteUser(uid);
  }
}
