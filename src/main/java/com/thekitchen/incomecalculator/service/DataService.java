package com.thekitchen.incomecalculator.service;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DataService<INPUT, OUTPUT, ID> {

  List<OUTPUT> getAll();

  Optional<OUTPUT> get(ID id);

  OUTPUT save(INPUT request);

  List<OUTPUT> saveAll(Collection<INPUT> requests);

  OUTPUT update(ID id, INPUT request);

  OUTPUT patch(ID id, JsonMergePatch patch);

  void delete(ID id);

  void deleteAll(Collection<ID> ids);
}
