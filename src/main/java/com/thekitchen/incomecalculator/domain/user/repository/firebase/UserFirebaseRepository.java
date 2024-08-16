package com.thekitchen.incomecalculator.domain.user.repository.firebase;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.config.firebase.FirebaseConfig.CollectionName;
import com.thekitchen.incomecalculator.domain.user.api.model.User;
import com.thekitchen.incomecalculator.domain.user.repository.UserRepository;
import com.thekitchen.incomecalculator.shared.repository.firebase.GenericFirebaseRepository;
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
      UserFirebaseEntityMapper mapper,
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
