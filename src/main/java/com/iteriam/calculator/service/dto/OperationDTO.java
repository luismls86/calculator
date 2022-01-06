package com.iteriam.calculator.service.dto;

import com.iteriam.calculator.common.enums.OperatorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    private BigDecimal operandOne;
    private BigDecimal operandTwo;
    private OperatorEnum operator;
    private BigDecimal result;
}
