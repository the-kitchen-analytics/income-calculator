package com.thekitchen.incomecalculator.controller;

import com.google.firebase.FirebaseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

  private final FirebaseApp firebaseApp;

  @RequestMapping("/health/firebase")
  ResponseEntity<FirebaseApp> firebaseHealthCheck() {
    return ResponseEntity.ok(firebaseApp);
  }

}
