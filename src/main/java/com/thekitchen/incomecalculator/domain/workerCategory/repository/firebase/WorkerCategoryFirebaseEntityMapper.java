package com.thekitchen.incomecalculator.domain.workerCategory.repository.firebase;

import com.thekitchen.incomecalculator.domain.workerCategory.api.model.WorkerCategory;
import com.thekitchen.incomecalculator.shared.mapper.FirebaseEnumMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

import java.util.Arrays;
import java.util.Objects;

@Mapper
public interface WorkerCategoryFirebaseEntityMapper
    extends FirebaseEnumMapper<WorkerCategory, WorkerCategoryFirebaseEntity> {

  @Override
  default WorkerCategory toModel(String entity) {
    return Arrays.stream(WorkerCategoryFirebaseEntity.values())
        .filter(it -> Objects.equals(it.value(), entity))
        .map(this::toModel)
        .findFirst()
        .orElseThrow();
  }

  @Override
  @ValueMapping(target = "MASTER", source = "MASTER")
  @ValueMapping(target = "TOP_MASTER", source = "TOP_MASTER")
  @ValueMapping(target = "INSTRUCTOR", source = "INSTRUCTOR")
  WorkerCategory toModel(WorkerCategoryFirebaseEntity entity);

  @Override
  @ValueMapping(target = "MASTER", source = "MASTER")
  @ValueMapping(target = "TOP_MASTER", source = "TOP_MASTER")
  @ValueMapping(target = "INSTRUCTOR", source = "INSTRUCTOR")
  WorkerCategoryFirebaseEntity toEntity(WorkerCategory model);
}
