package com.thekitchen.incomecalculator.config.firebase;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

  @Bean
  FirebaseApp firebaseApp(FirebaseProperties properties, FirebaseAppFactory factory) {
    return factory.build(properties);
  }

  @Bean
  Firestore firestoreClient() {
    return FirestoreClient.getFirestore();
  }

}
