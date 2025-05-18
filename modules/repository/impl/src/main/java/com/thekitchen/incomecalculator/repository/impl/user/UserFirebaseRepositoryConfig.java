package com.thekitchen.incomecalculator.repository.impl.user;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.FirebaseRepository;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseRepository;
import com.thekitchen.incomecalculator.model.User;
import com.thekitchen.incomecalculator.repository.api.CrudRepository;
import com.thekitchen.incomecalculator.repository.impl.GenericCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFirebaseRepositoryConfig {

  @Bean
  FirebaseRepository<UserFirebaseEntity> userFirebaseRepository(
      final Firestore firestore
  ) {
    return new GenericFirebaseRepository<>(
        firestore,
        "users",
        UserFirebaseEntity.class
    );
  }

  @Bean
  FirebaseCrudApi<User> userFirebaseCrudApi(
      FirebaseRepository<UserFirebaseEntity> userFirebaseRepository,
      UserFirebaseEntityMapper userFirebaseEntityMapper
  ) {
    return new GenericFirebaseCrudApi<>(userFirebaseEntityMapper, userFirebaseRepository);
  }

  @Bean
  CrudRepository<User, String> userRepository(
      FirebaseCrudApi<User> userFirebaseCrudApi
  ) {
    return new GenericCrudRepository<>(userFirebaseCrudApi);
  }

}
