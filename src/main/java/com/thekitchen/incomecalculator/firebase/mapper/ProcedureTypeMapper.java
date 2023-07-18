package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.service.model.ProcedureType;
import org.mapstruct.Mapper;

@Mapper
public interface ProcedureTypeMapper extends EnumMapper<ProcedureType> {

  @Override
  default Class<ProcedureType> getEnumClass() {
    return ProcedureType.class;
  }
}
