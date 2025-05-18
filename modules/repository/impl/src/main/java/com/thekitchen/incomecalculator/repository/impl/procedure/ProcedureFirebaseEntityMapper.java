package com.thekitchen.incomecalculator.repository.impl.procedure;

import com.thekitchen.incomecalculator.firebase.core.FirebaseEntityMapper;
import com.thekitchen.incomecalculator.model.Procedure;
import com.thekitchen.incomecalculator.repository.impl.procedureType.ProcedureTypeFirebaseEntityMapper;
import com.thekitchen.incomecalculator.repository.impl.workerCategory.WorkerCategoryFirebaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ProcedureTypeFirebaseEntityMapper.class, WorkerCategoryFirebaseEntityMapper.class})
public interface ProcedureFirebaseEntityMapper extends FirebaseEntityMapper<Procedure, ProcedureFirebaseEntity> {

}
