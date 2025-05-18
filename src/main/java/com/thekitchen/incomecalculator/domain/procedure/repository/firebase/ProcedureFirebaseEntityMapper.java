package com.thekitchen.incomecalculator.domain.procedure.repository.firebase;

import com.glebremniov.firebase.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.domain.procedure.api.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedureType.repository.firebase.ProcedureTypeFirebaseEntityMapper;
import com.thekitchen.incomecalculator.domain.workerCategory.repository.firebase.WorkerCategoryFirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ProcedureTypeFirebaseEntityMapper.class, WorkerCategoryFirebaseEntityMapper.class})
public interface ProcedureFirebaseEntityMapper extends FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> {

}
