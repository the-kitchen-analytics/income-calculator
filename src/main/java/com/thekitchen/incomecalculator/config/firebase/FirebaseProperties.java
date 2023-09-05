package com.thekitchen.incomecalculator.config.firebase;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "firebase")
public record FirebaseProperties(String projectId, String databaseUrl) {

}
