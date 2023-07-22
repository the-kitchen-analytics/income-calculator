package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.firebase.entity.UserFirebaseEntity;
import com.thekitchen.incomecalculator.service.model.User;
import org.mapstruct.Mapper;

@Mapper(uses = {WorkerCategoryMapper.class})
public interface UserFirebaseEntityMapper extends FirebaseEntityMapper<User, UserFirebaseEntity> {

}
