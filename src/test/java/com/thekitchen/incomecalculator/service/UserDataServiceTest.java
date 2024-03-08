package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.UserView;
import com.thekitchen.incomecalculator.repository.UserRepository;
import com.thekitchen.incomecalculator.service.mapper.UserRequestMapper;
import com.thekitchen.incomecalculator.service.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDataServiceTest {

  private static final String ID = "some id";

  @Mock
  private User user;
  @Mock
  private UserView userView;
  @Mock
  private UserRepository userRepository;
  @Mock
  private UserRequestMapper mapper;
  @Mock
  private UserDataDeletionService deletionService;

  @InjectMocks
  private UserDataService underTest;


  @Test
  void delete_Should_CallDeletionService_When_UserIsPresent() {
    // Given
    final var uid = "some uid";
    when(userRepository.getById(ID)).thenReturn(Optional.of(user));
    when(mapper.toView(user)).thenReturn(userView);
    when(userView.uid()).thenReturn(uid);

    // When
    underTest.delete(ID);

    // Then
    verify(deletionService).deleteByUid(uid);
    verify(userRepository).delete(ID);
  }

  @Test
  void delete_Should_NotCallDeletionService_When_NoUser() {
    // Given
    when(userRepository.getById(ID)).thenReturn(Optional.empty());

    // When
    underTest.delete(ID);

    // Then
    verifyNoInteractions(deletionService);
    verify(userRepository).delete(ID);
  }
}
