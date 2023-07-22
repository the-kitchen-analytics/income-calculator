package com.thekitchen.incomecalculator.config.firebase;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class FirebaseConfig {

  @Bean
  FirebaseApp firebaseApp(FirebaseProperties properties, FirebaseAppFactory factory) {
    return factory.build(properties);
  }

  @Bean
  @DependsOn("firebaseApp")
  Firestore firestoreClient() {
    return FirestoreClient.getFirestore();
  }

}
