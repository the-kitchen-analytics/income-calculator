package com.thekitchen.incomecalculator.repository.impl.user;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.model.User;
import com.thekitchen.incomecalculator.repository.impl.workerCategory.WorkerCategoryFirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {WorkerCategoryFirebaseEntityMapper.class})
public interface UserFirebaseEntityMapper extends FirebaseEntityMapper<User, UserFirebaseEntity> {

}
