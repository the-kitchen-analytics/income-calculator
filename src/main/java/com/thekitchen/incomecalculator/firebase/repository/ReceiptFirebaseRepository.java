package com.thekitchen.incomecalculator.firebase.repository;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.config.firebase.FirebaseConfig.CollectionName;
import com.thekitchen.incomecalculator.firebase.entity.ReceiptFirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.repository.ReceiptRepository;
import com.thekitchen.incomecalculator.service.model.Receipt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptFirebaseRepository
    extends GenericFirebaseRepository<Receipt, ReceiptFirebaseEntity>
    implements ReceiptRepository {

  public ReceiptFirebaseRepository(
      FirebaseEntityMapper<Receipt, ReceiptFirebaseEntity> mapper,
      Firestore firestore) {
    super(mapper, firestore, CollectionName.RECEIPTS.getValue(), ReceiptFirebaseEntity.class);
  }

  @Override
  public List<Receipt> findAllByUserId(String uid) {
    return getAll().stream()
        .filter(receipt -> receipt.uid().equals(uid))
        .toList();
  }

  @Override
  public List<Receipt> getAll() {
    return super.getAll();
  }

  @Override
  public Optional<Receipt> getById(String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    return super.getById(id);
  }

  @Override
  public Receipt save(Receipt receipt) {
    Objects.requireNonNull(receipt, "Receipt cannot be null");
    return super.create(receipt);
  }

  @Override
  public List<Receipt> saveAll(Collection<Receipt> receipts) {
    Objects.requireNonNull(receipts, "Receipts cannot be null");
    return receipts.stream()
        .map(this::create)
        .toList();
  }

  @Override
  public Receipt update(String id, Receipt receipt) {
    Objects.requireNonNull(id, "ID cannot be null");
    Objects.requireNonNull(receipt, "Receipt cannot be null");
    return super.update(id, receipt);
  }

  @Override
  public void delete(String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    super.delete(id);
  }

  @Override
  public void deleteAll(Collection<String> ids) {
    Objects.requireNonNull(ids, "IDs cannot be null");
    super.deleteAll(ids);
  }
}
