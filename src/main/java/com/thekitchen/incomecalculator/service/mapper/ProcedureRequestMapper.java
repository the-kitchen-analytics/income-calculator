package com.thekitchen.incomecalculator.service.mapper;

import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureResponse;
import com.thekitchen.incomecalculator.service.model.Procedure;
import org.mapstruct.Mapper;

@Mapper
public interface ProcedureRequestMapper extends RequestMapper<Procedure, ProcedureRequest, ProcedureResponse> {

}
