package com.thekitchen.incomecalculator.repository.impl.config;

import com.thekitchen.incomecalculator.firebase.core.impl.FirebaseDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

  @Bean
  FirebaseDateTimeConverter firebaseDateTimeConverter() {
    return new FirebaseDateTimeConverter();
  }

}
