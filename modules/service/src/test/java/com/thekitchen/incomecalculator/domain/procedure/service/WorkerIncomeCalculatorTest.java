package com.thekitchen.incomecalculator.domain.procedure.service;

import com.thekitchen.incomecalculator.domain.procedure.api.rest.PriceDetails;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WorkerIncomeCalculatorTest {

  private final WorkerIncomeCalculator calculator =
      new WorkerIncomeCalculator();


  @ParameterizedTest
  @MethodSource("provideTestData")
  public void calculate_shouldReturnExpectedResult(
      BigDecimal price,
      BigDecimal workerRate,
      BigDecimal expectedResult
  ) {
    // Given
    var details = new PriceDetails(price, workerRate, WorkerCategoryView.MASTER);

    // When
    var result = calculator.calculate(details);

    // Then
    assertThat(result).isEqualByComparingTo(expectedResult);
  }

  // Provide the test data for the parameterized test
  private static Stream<Arguments> provideTestData() {
    return Stream.of(
        Arguments.of(new BigDecimal("100.123"), new BigDecimal("1.2345"), new BigDecimal("123.602")),
        Arguments.of(new BigDecimal("0.00"), new BigDecimal("1.2345"), BigDecimal.ZERO),
        Arguments.of(new BigDecimal("100.123"), new BigDecimal("0.00"), BigDecimal.ZERO),
        Arguments.of(new BigDecimal("1.005"), new BigDecimal("1.001"), new BigDecimal("1.006")),
        Arguments.of(new BigDecimal("9999999999.999"), new BigDecimal("1.0001"), new BigDecimal("10000999999.999"))
    );
  }

}
