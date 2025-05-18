package com.thekitchen.incomecalculator.autoconfig.firebase.starter;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import com.thekitchen.incomecalculator.firebase.core.impl.FirebaseDateTimeConverter;
import com.thekitchen.incomecalculator.firebase.starter.FirebaseAppFactory;
import com.thekitchen.incomecalculator.firebase.starter.FirebaseConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;

@ConditionalOnProperty(prefix = "firebase", name = "project-id")
@EnableConfigurationProperties(FirebaseConfigurationProperties.class)
@AutoConfiguration
public class FirebaseAutoConfiguration {

  @ConditionalOnMissingBean
  @Bean
  FirebaseAppFactory firebaseAppFactory() {
    return new FirebaseAppFactory();
  }

  @ConditionalOnMissingBean
  @Bean
  FirebaseApp firebaseApp(
      final FirebaseConfigurationProperties properties,
      final FirebaseAppFactory factory
  ) throws IOException {
    return factory.build(properties);
  }

  @Bean
  @DependsOn("firebaseApp")
  Firestore firestoreClient() {
    return FirestoreClient.getFirestore();
  }

  @ConditionalOnMissingBean
  @Bean
  FirebaseDateTimeConverter firebaseDateTimeConverter() {
    return new FirebaseDateTimeConverter();
  }

}
