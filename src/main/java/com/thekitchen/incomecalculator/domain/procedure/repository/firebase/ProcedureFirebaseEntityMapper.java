package com.thekitchen.incomecalculator.domain.procedure.repository.firebase;

import com.thekitchen.incomecalculator.domain.procedure.api.model.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedureType.repository.firebase.ProcedureTypeFirebaseEntityMapper;
import com.thekitchen.incomecalculator.domain.workerCategory.repository.firebase.WorkerCategoryFirebaseEntityMapper;
import com.thekitchen.incomecalculator.shared.repository.firebase.FirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ProcedureTypeFirebaseEntityMapper.class, WorkerCategoryFirebaseEntityMapper.class})
public interface ProcedureFirebaseEntityMapper extends FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> {

}
