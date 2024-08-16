package com.thekitchen.incomecalculator.domain.workerCategory;

import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.domain.workerCategory.api.rest.WorkerCategoryView;
import com.thekitchen.incomecalculator.shared.mapper.ViewModelMapper;
import org.mapstruct.Mapper;

@Mapper
public interface WorkerCategoryMapper
    extends ViewModelMapper<WorkerCategoryView, WorkerCategory> {
}
