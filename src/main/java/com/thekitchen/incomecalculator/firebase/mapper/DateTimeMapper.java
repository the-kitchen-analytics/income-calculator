package com.thekitchen.incomecalculator.firebase.mapper;

import com.google.cloud.Timestamp;
import java.time.Instant;
import org.mapstruct.Mapper;

@Mapper
public interface DateTimeMapper {

  default Instant toInstant(Timestamp timestamp) {
    return timestamp.toSqlTimestamp().toInstant();
  }

  default Timestamp toTimestamp(Instant instant) {
    return Timestamp.ofTimeMicroseconds(instant.toEpochMilli());
  }

}
