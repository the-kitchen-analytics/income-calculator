package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.ReceiptRequest;
import com.thekitchen.incomecalculator.controller.model.ReceiptView;
import com.thekitchen.incomecalculator.service.ReceiptDataService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receipts")
public class ReceiptController extends AbstractCrudController<ReceiptRequest, ReceiptView, String> {

  private final ReceiptDataService service;

  ReceiptController(ReceiptDataService service) {
    super(service);
    this.service = service;
  }

  @GetMapping
  protected ResponseEntity<List<ReceiptView>> getAll(@RequestParam(required = false) String uid) {
    return Optional.ofNullable(uid)
        .map(service::findAllByUserId)
        .map(ResponseEntity::ok)
        .orElseGet(super::getAll);
  }

  @Override
  @GetMapping("{id}")
  protected ResponseEntity<ReceiptView> get(@PathVariable String id) {
    return super.get(id);
  }

  @GetMapping("grouped")
  protected ResponseEntity<Map<String, List<ReceiptView>>> grouped() {
    var result = service.getAllGroupedByUserId();
    return ResponseEntity.ok(result);
  }

  @Override
  @PostMapping
  protected ResponseEntity<List<ReceiptView>> saveAll(@RequestBody Collection<ReceiptRequest> request) {
    return super.saveAll(request);
  }

  @Override
  @PutMapping("{id}")
  protected ResponseEntity<ReceiptView> update(@PathVariable String id, ReceiptRequest receiptRequest) {
    return super.update(id, receiptRequest);
  }

  @Override
  @DeleteMapping("{id}")
  protected ResponseEntity<Void> delete(@PathVariable String id) {
    return super.delete(id);
  }

  @Override
  @DeleteMapping
  protected ResponseEntity<Void> deleteAll(@RequestBody Collection<String> strings) {
    return super.deleteAll(strings);
  }
}
