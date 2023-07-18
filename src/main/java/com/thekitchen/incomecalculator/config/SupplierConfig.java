package com.thekitchen.incomecalculator.config;

import java.util.UUID;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierConfig {

  @Bean
  Supplier<UUID> uuidSupplier() {
    return UUID::randomUUID;
  }

}
