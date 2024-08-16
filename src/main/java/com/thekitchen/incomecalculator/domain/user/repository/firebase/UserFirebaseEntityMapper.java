package com.thekitchen.incomecalculator.domain.user.repository.firebase;

import com.thekitchen.incomecalculator.domain.user.api.model.User;
import com.thekitchen.incomecalculator.domain.workerCategory.repository.firebase.WorkerCategoryFirebaseEntityMapper;
import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {WorkerCategoryFirebaseEntityMapper.class})
public interface UserFirebaseEntityMapper extends FirebaseEntityMapper<User, UserFirebaseEntity> {

}
