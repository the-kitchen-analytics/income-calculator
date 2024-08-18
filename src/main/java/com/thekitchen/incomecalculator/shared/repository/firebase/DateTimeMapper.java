package com.thekitchen.incomecalculator.shared.repository.firebase;

import com.google.cloud.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DateTimeMapper {

  public Instant toInstant(Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }

    return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
  }

  public Timestamp toTimestamp(Instant instant) {
    if (instant == null) {
      return null;
    }

    return Timestamp.ofTimeSecondsAndNanos(instant.getEpochSecond(), instant.getNano());
  }

}
