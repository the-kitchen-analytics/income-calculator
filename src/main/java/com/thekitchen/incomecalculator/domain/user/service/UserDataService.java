package com.thekitchen.incomecalculator.domain.user.service;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.domain.user.api.model.User;
import com.thekitchen.incomecalculator.domain.user.api.rest.CreateUserRequest;
import com.thekitchen.incomecalculator.domain.user.api.rest.UserView;
import com.thekitchen.incomecalculator.domain.user.repository.UserRepository;
import com.thekitchen.incomecalculator.shared.service.AbstractDataService;
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

  @Override
  protected User applyPatch(JsonMergePatch patch, User model) {
    throw new UnsupportedOperationException("Have not implemented yet.");
  }
}
