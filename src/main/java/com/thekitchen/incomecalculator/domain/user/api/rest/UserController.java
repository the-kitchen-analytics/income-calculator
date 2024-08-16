package com.thekitchen.incomecalculator.domain.user.api.rest;

import com.thekitchen.incomecalculator.domain.user.service.UserDataService;
import com.thekitchen.incomecalculator.shared.api.rest.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends AbstractCrudController<CreateUserRequest, UserView, String> {

  UserController(UserDataService service) {
    super(service);
  }
}
