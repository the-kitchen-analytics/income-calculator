package com.thekitchen.incomecalculator.firebase.mapper;

import com.thekitchen.incomecalculator.util.StringUtils;

@FunctionalInterface
public interface EnumMapper<E extends Enum<E>> {

  Class<E> getEnumClass();

  default E toModel(String value) {
    return E.valueOf(getEnumClass(), StringUtils.toUpperCase(value));
  }

  default String toEntity(E value) {
    return StringUtils.toKebabCase(value.toString());
  }

}
