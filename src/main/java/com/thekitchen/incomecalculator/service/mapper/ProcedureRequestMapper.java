package com.thekitchen.incomecalculator.service.mapper;

import com.thekitchen.incomecalculator.controller.model.CreateProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.PriceDetails;
import com.thekitchen.incomecalculator.controller.model.ProcedureRequest;
import com.thekitchen.incomecalculator.controller.model.ProcedureType;
import com.thekitchen.incomecalculator.controller.model.ProcedureView;
import com.thekitchen.incomecalculator.service.model.Procedure;
import com.thekitchen.incomecalculator.service.model.WorkerCategory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ProcedureRequestMapper
    extends RequestMapper<Procedure, ProcedureRequest, ProcedureView> {

  default List<ProcedureRequest> fromCreateRequest(CreateProcedureRequest request) {
    return request.prices().stream()
        .map(details -> fromDetails(request.name(), request.type(), details))
        .toList();
  }

  default ProcedureRequest fromDetails(String name, ProcedureType procedureType, PriceDetails details) {
    return new ProcedureRequest(
        name,
        procedureType,
        details.workerCategory(),
        details.price(),
        calculateWorkerIncome(details));
  }

  default BigDecimal calculateWorkerIncome(PriceDetails details) {
    return details.price()
        .multiply(details.workerRate())
        .setScale(3, RoundingMode.HALF_UP);
  }

  WorkerCategory toModel(com.thekitchen.incomecalculator.controller.model.WorkerCategory request);

  com.thekitchen.incomecalculator.service.model.ProcedureType toModel(com.thekitchen.incomecalculator.controller.model.ProcedureType request);

}
