package com.thekitchen.incomecalculator.firebase.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "firebase")
public record FirebaseConfigurationProperties(String projectId, String databaseUrl) {

}
