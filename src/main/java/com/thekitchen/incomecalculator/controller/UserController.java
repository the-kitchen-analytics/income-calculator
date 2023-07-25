package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.CreateUserRequest;
import com.thekitchen.incomecalculator.controller.model.UserView;
import com.thekitchen.incomecalculator.service.UserDataService;
import java.util.Collection;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends AbstractCrudController<CreateUserRequest, UserView, String> {

  UserController(UserDataService service) {
    super(service);
  }

  @Override
  @GetMapping
  protected ResponseEntity<List<UserView>> getAll() {
    return super.getAll();
  }

  @Override
  @GetMapping("{id}")
  protected ResponseEntity<UserView> get(@PathVariable String id) {
    return super.get(id);
  }

  @Override
  @PostMapping
  protected ResponseEntity<UserView> save(CreateUserRequest userRequest) {
    return super.save(userRequest);
  }

  @Override
  @PutMapping("{id}")
  protected ResponseEntity<UserView> update(@PathVariable String id, CreateUserRequest userRequest) {
    return super.update(id, userRequest);
  }

  @Override
  @DeleteMapping("{id}")
  protected ResponseEntity<Void> delete(@PathVariable String id) {
    return super.delete(id);
  }

  @Override
  @DeleteMapping
  protected ResponseEntity<Void> deleteAll(Collection<String> strings) {
    return super.deleteAll(strings);
  }
}
