package com.thekitchen.incomecalculator.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAppFactory {

  public FirebaseApp build(FirebaseProperties properties) {
    var options = firebaseOptions(properties);

    return FirebaseApp.initializeApp(options);
  }

  private FirebaseOptions firebaseOptions(FirebaseProperties properties) {
    var credentials = googleCredentials(properties);

    return FirebaseOptions.builder()
        .setCredentials(credentials)
        .setDatabaseUrl(properties.databaseUrl())
        .build();
  }

  private GoogleCredentials googleCredentials(FirebaseProperties properties) {
    try (var serviceAccount = Files.newInputStream(Path.of(properties.serviceAccountFilePath()))) {
      return GoogleCredentials.fromStream(serviceAccount);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
