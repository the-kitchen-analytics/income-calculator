package com.thekitchen.incomecalculator.domain.receipt.service;

import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.thekitchen.incomecalculator.domain.receipt.api.model.Receipt;
import com.thekitchen.incomecalculator.domain.receipt.api.rest.ReceiptRequest;
import com.thekitchen.incomecalculator.domain.receipt.api.rest.ReceiptView;
import com.thekitchen.incomecalculator.domain.receipt.repository.ReceiptRepository;
import com.thekitchen.incomecalculator.shared.service.AbstractDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReceiptDataService extends AbstractDataService<Receipt, ReceiptRequest, ReceiptView, String> {

  private final ReceiptRepository repository;
  private final ReceiptRequestMapper mapper;

  public ReceiptDataService(ReceiptRequestMapper mapper, ReceiptRepository repository) {
    super(mapper, repository);
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<ReceiptView> findAllByUserId(String uid) {
    return repository.findAllByUserId(uid)
        .stream()
        .map(mapper::toView)
        .toList();
  }

  public Map<String, List<ReceiptView>> getAllGroupedByUserId() {
    return super.getAll()
        .stream()
        .collect(Collectors.groupingBy(ReceiptView::uid));
  }

  @Override
  protected Receipt applyPatch(JsonMergePatch patch, Receipt receipt) {
    throw new UnsupportedOperationException("Have not implemented yet.");
  }
}
