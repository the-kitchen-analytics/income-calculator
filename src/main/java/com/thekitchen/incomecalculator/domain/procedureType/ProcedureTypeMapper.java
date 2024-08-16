package com.thekitchen.incomecalculator.domain.procedureType;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import org.mapstruct.Mapper;

@Mapper
public interface ProcedureTypeMapper {

  ProcedureType toModel(ProcedureTypeView view);
}
