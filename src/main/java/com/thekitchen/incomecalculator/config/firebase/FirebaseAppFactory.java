package com.thekitchen.incomecalculator.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAppFactory {

  public FirebaseApp build(FirebaseProperties properties) {
    var options = firebaseOptions(properties);

    return FirebaseApp.initializeApp(options);
  }

  private FirebaseOptions firebaseOptions(FirebaseProperties properties) {
    var credentials = googleCredentials();

    return FirebaseOptions.builder()
        .setProjectId(properties.projectId())
        .setCredentials(credentials)
        .setDatabaseUrl(properties.databaseUrl())
        .build();
  }

  @SneakyThrows
  private GoogleCredentials googleCredentials() {
    return GoogleCredentials.getApplicationDefault();
  }
}
