package com.thekitchen.incomecalculator.controller;

import com.thekitchen.incomecalculator.controller.model.ReceiptRequest;
import com.thekitchen.incomecalculator.controller.model.ReceiptView;
import com.thekitchen.incomecalculator.service.ReceiptDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("receipts")
public class ReceiptController extends AbstractCrudController<ReceiptRequest, ReceiptView, String> {

  private final ReceiptDataService service;

  ReceiptController(ReceiptDataService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(params = "uid")
  protected ResponseEntity<List<ReceiptView>> getAll(@RequestParam String uid) {
    return ResponseEntity.ok(service.findAllByUserId(uid));
  }

  @GetMapping("grouped")
  protected ResponseEntity<Map<String, List<ReceiptView>>> grouped() {
    var result = service.getAllGroupedByUserId();
    return ResponseEntity.ok(result);
  }
}
