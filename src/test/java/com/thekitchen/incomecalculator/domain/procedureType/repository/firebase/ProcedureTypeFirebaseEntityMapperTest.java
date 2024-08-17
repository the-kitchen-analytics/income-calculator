package com.thekitchen.incomecalculator.domain.procedureType.repository.firebase;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProcedureTypeFirebaseEntityMapperTest {

  private final ProcedureTypeFirebaseEntityMapper mapper =
      new ProcedureTypeFirebaseEntityMapperImpl();

  @ParameterizedTest
  @MethodSource("toEntityStringTestParams")
  void toModelTest(ProcedureType expected, String input) {
    // When
    var actual = mapper.toModel(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("toEntityTestParams")
  void toModelTest(ProcedureType expected, ProcedureTypeFirebaseEntity input) {
    // When
    var actual = mapper.toModel(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("toEntityTestParams")
  void toEntityTest(ProcedureType input, ProcedureTypeFirebaseEntity expected) {
    // When
    var actual = mapper.toEntity(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("toEntityStringTestParams")
  void toEntityStringTest(ProcedureType input, String expected) {
    // When
    var actual = mapper.toEntityString(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> toEntityTestParams() {
    return Stream.of(
        arguments(ProcedureType.MANICURE, ProcedureTypeFirebaseEntity.MANICURE),
        arguments(ProcedureType.PEDICURE, ProcedureTypeFirebaseEntity.PEDICURE),
        arguments(ProcedureType.SPA, ProcedureTypeFirebaseEntity.SPA),
        arguments(ProcedureType.BROWS, ProcedureTypeFirebaseEntity.BROWS),
        arguments(null, null)
    );
  }

  private static Stream<Arguments> toEntityStringTestParams() {
    return Stream.of(
        arguments(ProcedureType.MANICURE, "manicure"),
        arguments(ProcedureType.PEDICURE, "pedicure"),
        arguments(ProcedureType.SPA, "spa"),
        arguments(ProcedureType.BROWS, "brows"),
        arguments(null, null)
    );
  }

}
