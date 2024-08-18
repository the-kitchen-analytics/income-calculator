package com.thekitchen.incomecalculator.shared.repository.firebase;

import com.google.cloud.Timestamp;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DateTimeMapperTest {

  private static final long SECONDS = 1723904227L;
  private static final int NANOS = 456000000;
  private static final Timestamp TIMESTAMP = Timestamp.ofTimeSecondsAndNanos(SECONDS, NANOS);
  private static final Instant INSTANT = Instant.ofEpochSecond(SECONDS, NANOS);

  private final DateTimeMapper mapper = new DateTimeMapper();

  @ParameterizedTest
  @MethodSource("testParams")
  void toInstantTest(Instant expected, Timestamp input) {
    // When
    var actual = mapper.toInstant(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("testParams")
  void toTimestampTest(Instant input, Timestamp expected) {
    // When
    var actual = mapper.toTimestamp(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> testParams() {
    return Stream.of(
        arguments(INSTANT, TIMESTAMP),
        arguments(null, null)
    );
  }
}
