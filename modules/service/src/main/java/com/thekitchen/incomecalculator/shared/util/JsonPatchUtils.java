package com.thekitchen.incomecalculator.shared.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonPatchUtils {

  public static <T> T applyPatch(
      ObjectMapper objectMapper,
      JsonMergePatch patch,
      T model,
      Class<T> clazz
  ) {
    try {
      var patched = patch.apply(objectMapper.convertValue(model, JsonNode.class));
      return objectMapper.treeToValue(patched, clazz);
    } catch (JsonPatchException | JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
