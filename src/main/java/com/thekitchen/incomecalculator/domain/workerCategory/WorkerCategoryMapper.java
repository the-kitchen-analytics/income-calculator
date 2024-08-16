package com.thekitchen.incomecalculator.domain.workerCategory;

import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;
import org.mapstruct.Mapper;

@Mapper
public interface WorkerCategoryMapper {

  WorkerCategory toModel(WorkerCategoryView view);

}
