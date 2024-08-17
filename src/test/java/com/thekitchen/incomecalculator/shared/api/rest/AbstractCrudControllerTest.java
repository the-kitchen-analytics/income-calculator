package com.thekitchen.incomecalculator.shared.api.rest;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.shared.service.DataService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class AbstractCrudControllerTest {

  static final class DummyRequest {
  }

  static final class DummyResponse {
  }

  static final class DummyController extends AbstractCrudController<DummyRequest, DummyResponse, Long> {

    public DummyController(DataService<DummyRequest, DummyResponse, Long> service) {
      super(service);
    }
  }

  private static final Long ID = 1L;
  private static final DummyRequest REQUEST = new DummyRequest();
  private static final DummyResponse RESPONSE = new DummyResponse();
  private static final ResponseEntity<DummyResponse> NOT_FOUND = ResponseEntity.notFound().build();

  @Mock
  private DataService<DummyRequest, DummyResponse, Long> service;

  @InjectMocks
  private DummyController controller;

  @Nested
  class GetAll {

    @Test
    void should_ReturnOk() {
      // Given
      var response = List.of(RESPONSE);
      given(service.getAll()).willReturn(response);

      // When
      var actual = controller.getAll();

      // Then
      verify(service).getAll();
      assertThat(actual).isEqualTo(ResponseEntity.ok(response));
    }
  }

  @Nested
  class Get {

    @Test
    void should_ReturnNotFound_When_NoEntity() {
      // Given
      given(service.get(ID)).willReturn(Optional.empty());

      // When
      var actual = controller.get(ID);

      // Then
      verify(service).get(ID);
      assertThat(actual).isEqualTo(NOT_FOUND);
    }

    @Test
    void should_ReturnOk_When_OptionalPresent() {
      // Given
      given(service.get(ID)).willReturn(Optional.of(RESPONSE));

      // When
      var actual = controller.get(ID);

      // Then
      verify(service).get(ID);
      assertThat(actual).isEqualTo(ResponseEntity.ok(RESPONSE));
    }
  }

  @Nested
  class Save {

    @Test
    void should_ReturnSaved() {
      // Given
      given(service.save(REQUEST)).willReturn(RESPONSE);

      // When
      var actual = controller.save(REQUEST);

      // Then
      verify(service).save(REQUEST);
      assertThat(actual).isEqualTo(ResponseEntity.ok(RESPONSE));
    }
  }

  @Nested
  class SaveAll {

    @Test
    void should_ReturnAllSaved() {
      // Given
      var request = List.of(REQUEST);
      var response = List.of(RESPONSE);
      given(service.saveAll(request)).willReturn(response);

      // When
      var actual = controller.saveAll(request);

      // Then
      verify(service).saveAll(request);
      assertThat(actual).isEqualTo(ResponseEntity.ok(response));
    }
  }

  @Nested
  class Update {

    @Test
    void should_ReturnNotFound_When_NoEntity() {
      // Given
      given(service.update(ID, REQUEST)).willThrow(NoSuchElementException.class);

      // When
      var actual = controller.update(ID, REQUEST);

      // Then
      verify(service).update(ID, REQUEST);
      assertThat(actual).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    void should_ReturnUpdated_When_EntityExists() {
      // Given
      given(service.update(ID, REQUEST)).willReturn(RESPONSE);

      // When
      var actual = controller.update(ID, REQUEST);

      // Then
      verify(service).update(ID, REQUEST);
      assertThat(actual).isEqualTo(ResponseEntity.ok(RESPONSE));
    }
  }

  @Nested
  class Patch {

    @Test
    void should_ReturnNotFound_When_NoEntity() {
      // Given
      var patch = Mockito.mock(JsonMergePatch.class);
      given(service.patch(ID, patch)).willThrow(NoSuchElementException.class);

      // When
      var actual = controller.patch(ID, patch);

      // Then
      verify(service).patch(ID, patch);
      assertThat(actual).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    void should_ReturnPatched_When_EntityExists() {
      // Given
      var patch = Mockito.mock(JsonMergePatch.class);
      given(service.patch(ID, patch)).willReturn(RESPONSE);

      // When
      var actual = controller.patch(ID, patch);

      // Then
      verify(service).patch(ID, patch);
      assertThat(actual).isEqualTo(ResponseEntity.ok(RESPONSE));
    }
  }

  @Nested
  class Delete {

    @Test
    void should_ReturnNoContent() {
      // When
      var actual = controller.delete(ID);

      // Then
      verify(service).delete(ID);
      assertThat(actual).isEqualTo(ResponseEntity.noContent().build());
    }
  }

  @Nested
  class DeleteAll {

    @Test
    void should_ReturnNoContent() {
      // When
      var actual = controller.deleteAll(List.of(ID));

      // Then
      verify(service).deleteAll(List.of(ID));
      assertThat(actual).isEqualTo(ResponseEntity.noContent().build());
    }
  }

}
