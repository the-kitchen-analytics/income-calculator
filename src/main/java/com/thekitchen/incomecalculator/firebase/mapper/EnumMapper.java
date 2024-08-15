package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.util.StringUtils;

import java.util.Optional;

@FunctionalInterface
public interface EnumMapper<E extends Enum<E>> {

  Class<E> getEnumClass();

  default E toModel(String value) {
    return Optional.ofNullable(value)
        .map((enumValue) -> E.valueOf(getEnumClass(), StringUtils.toUpperCase(enumValue)))
        .orElse(null);
  }

  default String toEntity(E value) {
    return Optional.ofNullable(value)
        .map((enumValue) -> StringUtils.toKebabCase(enumValue.toString()))
        .orElse(null);
  }

}
