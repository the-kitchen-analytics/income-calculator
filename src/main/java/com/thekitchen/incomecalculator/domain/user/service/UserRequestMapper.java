package com.thekitchen.incomecalculator.domain.user.service;

import com.thekitchen.incomecalculator.domain.user.api.model.User;
import com.thekitchen.incomecalculator.domain.user.api.rest.CreateUserRequest;
import com.thekitchen.incomecalculator.domain.user.api.rest.UserView;
import com.thekitchen.incomecalculator.domain.workerCategory.WorkerCategoryMapper;
import com.thekitchen.incomecalculator.shared.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(uses = WorkerCategoryMapper.class)
public interface UserRequestMapper extends RequestMapper<User, CreateUserRequest, UserView> {

}
