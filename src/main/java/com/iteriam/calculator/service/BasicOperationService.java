package com.iteriam.calculator.service;

import com.iteriam.calculator.common.exception.CustomException;
import com.iteriam.calculator.common.enums.OperatorEnum;

import java.math.BigDecimal;

public interface BasicOperationService {
    BigDecimal operate(OperatorEnum operator, BigDecimal operandOne, BigDecimal operandTwo) throws CustomException;
}
