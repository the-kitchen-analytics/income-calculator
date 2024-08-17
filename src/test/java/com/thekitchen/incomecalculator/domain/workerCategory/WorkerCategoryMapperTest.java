package com.thekitchen.incomecalculator.domain.workerCategory;

import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WorkerCategoryMapperTest {

  private final WorkerCategoryMapper mapper = new WorkerCategoryMapperImpl();

  @ParameterizedTest
  @MethodSource("testParams")
  void toModelTest(WorkerCategoryView input, WorkerCategory expected) {
    // Given -> When
    var actual = mapper.toModel(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("testParams")
  void toViewTest(WorkerCategoryView expected, WorkerCategory input) {
    // Given -> When
    var actual = mapper.toView(input);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> testParams() {
    return Stream.of(
        arguments(WorkerCategoryView.MASTER, WorkerCategory.MASTER),
        arguments(WorkerCategoryView.TOP_MASTER, WorkerCategory.TOP_MASTER),
        arguments(WorkerCategoryView.INSTRUCTOR, WorkerCategory.INSTRUCTOR),
        arguments(null, null)
    );
  }

}
