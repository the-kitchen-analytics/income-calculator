package com.thekitchen.incomecalculator.service;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.shared.mapper.RequestMapper;
import com.thekitchen.incomecalculator.shared.repository.Repository;
import com.thekitchen.incomecalculator.shared.service.AbstractDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AbstractDataServiceTest {

  static class Model {
  }

  static class Request {
  }

  static class View {
  }

  static class Id {
  }

  static class UnderTest extends AbstractDataService<Model, Request, View, Id> {
    public UnderTest(RequestMapper<Model, Request, View> mapper, Repository<Model, Id> repository) {
      super(mapper, repository);
    }

    @Override
    protected Model applyPatch(JsonMergePatch patch, Model model) {
      throw new UnsupportedOperationException("Have not implemented yet.");
    }
  }

  private static final Model MODEL = new Model();
  private static final Model SAVED_MODEL = new Model();
  private static final Request REQUEST = new Request();
  private static final View VIEW = new View();
  private static final Id ID = new Id();

  @Mock
  private RequestMapper<Model, Request, View> mapper;
  @Mock
  private Repository<Model, Id> repository;
  @InjectMocks
  private UnderTest underTest;

  @Test
  void getAll_Should_DelegateToRepository() {
    // Given
    when(repository.getAll()).thenReturn(List.of(MODEL));
    when(mapper.toView(MODEL)).thenReturn(VIEW);

    // When
    final var actual = underTest.getAll();

    // Then
    assertThat(actual).containsExactly(VIEW);
  }

  @Test
  void get_Should_DelegateToRepository() {
    // Given
    when(repository.getById(ID)).thenReturn(Optional.of(MODEL));
    when(mapper.toView(MODEL)).thenReturn(VIEW);

    // When
    final var actual = underTest.get(ID);

    // Then
    assertThat(actual).hasValue(VIEW);
  }

  @Test
  void save_Should_DelegateToRepository() {
    // Given
    when(mapper.toModel(REQUEST)).thenReturn(MODEL);
    when(repository.save(MODEL)).thenReturn(SAVED_MODEL);
    when(mapper.toView(SAVED_MODEL)).thenReturn(VIEW);

    // When
    final var actual = underTest.save(REQUEST);

    // Then
    assertThat(actual).isEqualTo(VIEW);
  }

  @Test
  void saveAll_Should_DelegateToRepository() {
    // Given
    when(mapper.toModel(REQUEST)).thenReturn(MODEL);
    when(repository.save(MODEL)).thenReturn(SAVED_MODEL);
    when(mapper.toView(SAVED_MODEL)).thenReturn(VIEW);

    // When
    final var actual = underTest.saveAll(Set.of(REQUEST));

    // Then
    assertThat(actual).containsExactly(VIEW);
  }

  @Test
  void update_Should_DelegateToRepository() {
    // Given
    when(mapper.toModel(REQUEST)).thenReturn(MODEL);
    when(repository.update(ID, MODEL)).thenReturn(SAVED_MODEL);
    when(mapper.toView(SAVED_MODEL)).thenReturn(VIEW);

    // When
    final var actual = underTest.update(ID, REQUEST);

    // Then
    assertThat(actual).isEqualTo(VIEW);
  }

  @Test
  void deleteAll_Should_DelegateToRepository() {
    // Given
    final var ids = Set.of(ID);

    // When
    underTest.deleteAll(ids);

    // Then
    verify(repository).deleteAll(ids);
  }

  @Test
  void delete_Should_DelegateToRepository() {
    // When
    underTest.delete(ID);

    // Then
    verify(repository).delete(ID);
  }
}
