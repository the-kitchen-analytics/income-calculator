package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.model.ProceduresQueryParams;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilter;
import com.thekitchen.incomecalculator.service.query.filter.QueryFilterFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcedureQueryParamsServiceTest {

  @Mock
  private List<ProcedureView> procedureViewList;
  @Mock
  private QueryFilter<ProceduresQueryParams, ProcedureView> filter;
  @Mock
  private ProceduresQueryParams queryParams;
  @Mock
  private QueryFilterFactory<ProceduresQueryParams, ProcedureView> filterFactory;
  @InjectMocks
  private ProcedureQueryParamsService underTest;

  @Test
  void shouldGetFactoryAndCallGet() {
    // Given
    when(filterFactory.get(queryParams))
        .thenReturn(filter);

    when(filter.filter(queryParams))
        .thenReturn(procedureViewList);

    // When
    var actual = underTest.get(queryParams);

    // Then
    assertThat(actual).isEqualTo(procedureViewList);
  }

}
