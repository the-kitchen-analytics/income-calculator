package com.thekitchen.incomecalculator.domain.procedure.service;

import com.thekitchen.incomecalculator.domain.procedure.api.model.Procedure;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.ProcedureRequest;
import com.thekitchen.incomecalculator.domain.procedure.api.rest.ProcedureView;
import com.thekitchen.incomecalculator.domain.workerCategory.WorkerCategoryMapper;
import com.thekitchen.incomecalculator.shared.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(uses = WorkerCategoryMapper.class)
public interface ProcedureRequestMapper
    extends RequestMapper<Procedure, ProcedureRequest, ProcedureView> {

}
