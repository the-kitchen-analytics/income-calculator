package com.thekitchen.incomecalculator.domain.procedureType;

import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import com.thekitchen.incomecalculator.domain.procedureType.api.rest.ProcedureTypeView;
import com.thekitchen.incomecalculator.shared.mapper.ViewModelMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ProcedureTypeMapper
    extends ViewModelMapper<ProcedureTypeView, ProcedureType> {

}
