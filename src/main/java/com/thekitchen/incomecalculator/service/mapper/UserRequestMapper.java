package com.thekitchen.incomecalculator.service.mapper;

import com.thekitchen.incomecalculator.controller.model.CreateUserRequest;
import com.thekitchen.incomecalculator.controller.model.UserView;
import com.thekitchen.incomecalculator.service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserRequestMapper extends RequestMapper<User, CreateUserRequest, UserView> {

}
