package com.thekitchen.incomecalculator.shared.repository.firebase;

import com.google.cloud.Timestamp;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper
public interface DateTimeMapper {

  default Instant toInstant(Timestamp timestamp) {
    return timestamp.toSqlTimestamp().toInstant();
  }

  default Timestamp toTimestamp(Instant instant) {
    return Timestamp.ofTimeMicroseconds(instant.toEpochMilli());
  }

}
