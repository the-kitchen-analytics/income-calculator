package com.thekitchen.incomecalculator.service;

import com.thekitchen.incomecalculator.controller.model.ReceiptRequest;
import com.thekitchen.incomecalculator.controller.model.ReceiptView;
import com.thekitchen.incomecalculator.repository.ReceiptRepository;
import com.thekitchen.incomecalculator.service.mapper.ReceiptMapper;
import com.thekitchen.incomecalculator.service.model.Receipt;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDataService extends AbstractDataService<Receipt, ReceiptRequest, ReceiptView, String> {

  private final ReceiptRepository repository;
  private final ReceiptMapper mapper;

  public ReceiptDataService(ReceiptMapper mapper, ReceiptRepository repository) {
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
}
