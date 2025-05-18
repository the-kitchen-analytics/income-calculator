package com.glebremniov.firebase.impl;

import com.google.cloud.Timestamp;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FirebaseDateTimeConverterTest {

  private static final long SECONDS = 1723904227L;
  private static final int NANOS = 456000000;
  private static final Timestamp TIMESTAMP = Timestamp.ofTimeSecondsAndNanos(SECONDS, NANOS);
  private static final Instant INSTANT = Instant.ofEpochSecond(SECONDS, NANOS);

  private final FirebaseDateTimeConverter mapper = new FirebaseDateTimeConverter();

  @ParameterizedTest(name = "{0}")
  @MethodSource("testParams")
  void toInstantTest(final String name, final Instant expected, final Timestamp input) {
    // When
    var actual = mapper.toJavaType(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("testParams")
  void toTimestampTest(final String name, final Instant input, final Timestamp expected) {
    // When
    var actual = mapper.toFirebaseType(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> testParams() {
    return Stream.of(
        arguments("Should return converted value", INSTANT, TIMESTAMP),
        arguments("Should return null when input is null", null, null)
    );
  }
}
