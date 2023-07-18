package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.service.model.WorkerCategory;
import org.mapstruct.Mapper;

@Mapper
public interface WorkerCategoryMapper extends EnumMapper<WorkerCategory> {

  @Override
  default Class<WorkerCategory> getEnumClass() {
    return WorkerCategory.class;
  }
}
