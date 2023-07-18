package com.thekitchen.incomecalculator.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

  public static String toKebabCase(String input) {
    return input.toLowerCase().replaceAll("_", "-");
  }

  public static String toUpperCase(String input) {
    return input.toUpperCase().replaceAll("-", "_");
  }

}
