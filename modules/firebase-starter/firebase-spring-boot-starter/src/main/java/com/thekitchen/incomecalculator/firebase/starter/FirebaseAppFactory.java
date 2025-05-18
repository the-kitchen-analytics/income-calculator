package com.thekitchen.incomecalculator.firebase.starter;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;

public class FirebaseAppFactory {

  public FirebaseApp build(FirebaseConfigurationProperties properties) throws IOException {
    var options = firebaseOptions(properties);

    return FirebaseApp.initializeApp(options);
  }

  private FirebaseOptions firebaseOptions(FirebaseConfigurationProperties properties) throws IOException {
    var credentials = googleCredentials();

    return FirebaseOptions.builder()
        .setProjectId(properties.projectId())
        .setCredentials(credentials)
        .setDatabaseUrl(properties.databaseUrl())
        .build();
  }

  private GoogleCredentials googleCredentials() throws IOException {
    return GoogleCredentials.getApplicationDefault();
  }
}
