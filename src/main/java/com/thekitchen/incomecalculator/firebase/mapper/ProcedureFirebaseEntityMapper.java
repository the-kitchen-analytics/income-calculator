package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.firebase.entity.ProcedureFirebaseEntity;
import com.thekitchen.incomecalculator.service.model.Procedure;
import org.mapstruct.Mapper;

@Mapper(uses = {ProcedureTypeMapper.class, WorkerCategoryMapper.class})
public interface ProcedureFirebaseEntityMapper extends FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> {

}
