package com.thekitchen.incomecalculator.util;

import com.thekitchen.incomecalculator.shared.util.StringUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

  @Nested
  class ToKebabCase {

    @ParameterizedTest
    @CsvSource({
        "HELLO_WORLD, hello-world",
        "BOB, bob"
    })
    void shouldConvertStringToKebabCase(String input, String expectedOutput) {
      // Act
      String result = StringUtils.toKebabCase(input);

      // Assert
      assertThat(result).isEqualTo(expectedOutput);
    }
  }

  @Nested
  class ToUpperCase {

    @ParameterizedTest
    @CsvSource({
        "hello-world, HELLO_WORLD",
        "bob, BOB"
    })
    void shouldConvertStringToCamelCase(String input, String expectedOutput) {
      // Act
      String result = StringUtils.toUpperCase(input);

      // Assert
      assertThat(result).isEqualTo(expectedOutput);
    }
  }
}
