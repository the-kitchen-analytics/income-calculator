package com.thekitchen.incomecalculator.repository;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.config.firebase.FirebaseConfig.CollectionName;
import com.thekitchen.incomecalculator.firebase.entity.UserFirebaseEntity;
import com.thekitchen.incomecalculator.firebase.mapper.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.firebase.repository.GenericFirebaseRepository;
import com.thekitchen.incomecalculator.service.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserFirebaseRepository
    extends GenericFirebaseRepository<User, UserFirebaseEntity>
    implements UserRepository {

  public UserFirebaseRepository(
      FirebaseEntityMapper<User, UserFirebaseEntity> mapper,
      Firestore firestore) {
    super(mapper, firestore, CollectionName.USERS.getValue(), UserFirebaseEntity.class);
  }

  @Override
  public List<User> getAll() {
    return super.getAll();
  }

  @Override
  public Optional<User> getById(String id) {
    Objects.requireNonNull(id, "ID cannot be null");
    return super.getById(id);
  }

  @Override
  public User save(User user) {
    Objects.requireNonNull(user, "Users cannot be null");
    return super.create(user);
  }

  @Override
  public List<User> saveAll(Collection<User> users) {
    Objects.requireNonNull(users, "Users cannot be null");
    return users.stream()
        .map(this::save)
        .toList();
  }

  @Override
  public User update(String id, User user) {
    Objects.requireNonNull(id, "ID cannot be null");
    Objects.requireNonNull(user, "User cannot be null");
    return super.update(id, user);
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
