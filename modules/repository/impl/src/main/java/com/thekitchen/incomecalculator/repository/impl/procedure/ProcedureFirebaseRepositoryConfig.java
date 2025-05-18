package com.thekitchen.incomecalculator.repository.impl.procedure;

import com.google.cloud.firestore.Firestore;
import com.thekitchen.incomecalculator.firebase.core.FirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.FirebaseRepository;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseCrudApi;
import com.thekitchen.incomecalculator.firebase.core.impl.GenericFirebaseRepository;
import com.thekitchen.incomecalculator.model.Procedure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcedureFirebaseRepositoryConfig {

  @Bean
  FirebaseRepository<ProcedureFirebaseEntity> procedureFirebaseRepository(
      final Firestore firestore
  ) {
    return new GenericFirebaseRepository<>(
        firestore,
        "procedures_v2",
        ProcedureFirebaseEntity.class
    );
  }

  @Bean
  FirebaseCrudApi<Procedure> procedureFirebaseCrudApi(
      final FirebaseRepository<ProcedureFirebaseEntity> procedureFirebaseRepository,
      final ProcedureFirebaseEntityMapper procedureFirebaseEntityMapper
  ) {
    return new GenericFirebaseCrudApi<>(procedureFirebaseEntityMapper, procedureFirebaseRepository);
  }

}
