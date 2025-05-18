package com.thekitchen.incomecalculator.domain.procedure.service;


import com.thekitchen.incomecalculator.domain.procedure.api.rest.PriceDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class WorkerIncomeCalculator {

  public BigDecimal calculate(PriceDetails details) {
    return details.price()
        .multiply(details.workerRate())
        .setScale(3, RoundingMode.HALF_UP);
  }

}
