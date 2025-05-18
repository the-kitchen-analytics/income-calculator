package com.glebremniov.firebase.impl;

import com.glebremniov.firebase.FirebaseTypeConverter;
import com.google.cloud.Timestamp;

import java.time.Instant;

/**
 * A converter that converts between {@link Timestamp} and {@link Instant}.
 * <p>
 * This class implements the {@link FirebaseTypeConverter} interface to provide
 * conversion methods for converting between Firebase and Java types.
 */
public class FirebaseDateTimeConverter
    implements FirebaseTypeConverter<Timestamp, Instant> {

  @Override
  public Instant toJavaType(Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }

    return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
  }

  @Override
  public Timestamp toFirebaseType(Instant instant) {
    if (instant == null) {
      return null;
    }

    return Timestamp.ofTimeSecondsAndNanos(instant.getEpochSecond(), instant.getNano());
  }

}
