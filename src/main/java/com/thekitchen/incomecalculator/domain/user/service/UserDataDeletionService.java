package com.thekitchen.incomecalculator.domain.user.service;

import com.google.firebase.auth.FirebaseAuth;
import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.domain.receipt.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

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
    log.info("Delete firebase auth: {}", uid);
    FirebaseAuth.getInstance().deleteUser(uid);
  }
}
