package com.iteriam.calculator.service;

import com.iteriam.calculator.common.enums.OperatorEnum;
import com.iteriam.calculator.common.exception.CustomException;
import com.iteriam.calculator.service.dto.OperationDTO;
import com.iteriam.calculator.service.implementation.BasicOperationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class BasicOperationServiceUnitTest {

    private BasicOperationService basicOperationService;
    private BigDecimal operandOne;
    private BigDecimal operandTwo;


    @BeforeEach
    void initialize() {
        basicOperationService = new BasicOperationServiceImpl();
        operandOne = new BigDecimal(4);
        operandTwo = new BigDecimal(6);
    }

    @Test
    void basicOperationService_operateWithAnAddition_returnCorrectAddition() throws CustomException {
        OperatorEnum operator = OperatorEnum.add;
        OperationDTO operationExpected = new OperationDTO(operandOne, operandTwo, operator, new BigDecimal(10));
        OperationDTO operation = basicOperationService.operate(operator, operandOne, operandTwo);
        assertThat(operation.equals(operationExpected));
    }

    @Test
    void basicOperationService_operateWithASubtraction_returnCorrectSubtraction() throws CustomException {
        OperatorEnum operator = OperatorEnum.sub;
        OperationDTO operationExpected = new OperationDTO(operandOne, operandTwo, operator, new BigDecimal(-2));
        OperationDTO operation = basicOperationService.operate(operator, operandOne, operandTwo);
        assertThat(operation.equals(operationExpected));
    }

}
