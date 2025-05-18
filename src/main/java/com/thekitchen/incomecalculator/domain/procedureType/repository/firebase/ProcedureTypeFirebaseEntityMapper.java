package com.thekitchen.incomecalculator.domain.procedureType.repository.firebase;

import com.glebremniov.firebase.FirebaseEnumMapper;
import com.thekitchen.incomecalculator.domain.procedureType.api.model.ProcedureType;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

import java.util.Arrays;
import java.util.Objects;

@Mapper
public interface ProcedureTypeFirebaseEntityMapper
    extends FirebaseEnumMapper<ProcedureType, ProcedureTypeFirebaseEntity> {

  @Override
  default ProcedureType toModel(String entity) {
    return Arrays.stream(ProcedureTypeFirebaseEntity.values())
        .filter(it -> Objects.equals(it.value(), entity))
        .map(this::toModel)
        .findFirst()
        .orElse(null);
  }

  @Override
  @ValueMapping(target = "SPA", source = "SPA")
  @ValueMapping(target = "BROWS", source = "BROWS")
  @ValueMapping(target = "MANICURE", source = "MANICURE")
  @ValueMapping(target = "PEDICURE", source = "PEDICURE")
  ProcedureType toModel(ProcedureTypeFirebaseEntity entity);

  @Override
  @ValueMapping(target = "SPA", source = "SPA")
  @ValueMapping(target = "BROWS", source = "BROWS")
  @ValueMapping(target = "MANICURE", source = "MANICURE")
  @ValueMapping(target = "PEDICURE", source = "PEDICURE")
  ProcedureTypeFirebaseEntity toEntity(ProcedureType model);
}
