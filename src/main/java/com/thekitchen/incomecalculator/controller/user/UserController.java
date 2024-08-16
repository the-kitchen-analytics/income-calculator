package com.thekitchen.incomecalculator.controller.user;

import com.thekitchen.incomecalculator.controller.AbstractCrudController;
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
