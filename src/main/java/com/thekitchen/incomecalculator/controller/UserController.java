package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.CreateUserRequest;
import com.thekitchen.incomecalculator.controller.model.UserView;
import com.thekitchen.incomecalculator.service.UserDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends AbstractCrudController<CreateUserRequest, UserView, String> {

  UserController(UserDataService service) {
    super(service);
  }
}
