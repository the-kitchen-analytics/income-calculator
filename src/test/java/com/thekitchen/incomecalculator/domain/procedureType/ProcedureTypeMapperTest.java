package com.thekitchen.incomecalculator.domain.procedureType;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProcedureTypeMapperTest {

  private final ProcedureTypeMapper mapper = new ProcedureTypeMapperImpl();

  @ParameterizedTest
  @MethodSource("testParams")
  void toModelTest(
      ProcedureTypeView input,
      ProcedureType expected
  ) {
    // Given -> When
    var actual = mapper.toModel(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("testParams")
  void toViewTest(
      ProcedureTypeView expected,
      ProcedureType input
  ) {
    // Given -> When
    var actual = mapper.toView(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> testParams() {
    return Stream.of(
        arguments(ProcedureTypeView.MANICURE, ProcedureType.MANICURE),
        arguments(ProcedureTypeView.PEDICURE, ProcedureType.PEDICURE),
        arguments(ProcedureTypeView.SPA, ProcedureType.SPA),
        arguments(ProcedureTypeView.BROWS, ProcedureType.BROWS),
        arguments(null, null)
    );
  }

}
