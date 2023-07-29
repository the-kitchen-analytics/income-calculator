package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.CreateUserRequest;
import com.thekitchen.incomecalculator.controller.model.UserView;
import com.thekitchen.incomecalculator.repository.UserRepository;
import com.thekitchen.incomecalculator.service.mapper.UserRequestMapper;
import com.thekitchen.incomecalculator.service.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDataService extends AbstractDataService<User, CreateUserRequest, UserView, String> {

  private final UserDataDeletionService deletionService;

  public UserDataService(
      UserRequestMapper mapper,
      UserRepository repository,
      UserDataDeletionService deletionService) {
    super(mapper, repository);
    this.deletionService = deletionService;
  }

  @Override
  public void delete(String id) {
    super.get(id)
        .map(UserView::uid)
        .ifPresent(deletionService::deleteByUid);

    super.delete(id);
  }
}
