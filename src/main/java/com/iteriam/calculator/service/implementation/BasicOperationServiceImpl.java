package com.iteriam.calculator.service.implementation;

import com.iteriam.calculator.bean.Operation;
import com.iteriam.calculator.common.exception.CustomException;
import com.iteriam.calculator.service.dto.OperationDTO;
import com.iteriam.calculator.common.enums.OperatorEnum;
import com.iteriam.calculator.service.BasicOperationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

@Service
@Slf4j
public class BasicOperationServiceImpl implements BasicOperationService {

    ModelMapper mapper = new ModelMapper();

    @Override
    public OperationDTO operate(OperatorEnum operator, BigDecimal operandOne, BigDecimal operandTwo) throws CustomException {

        try {
            Class<?> clazz = Class.forName(operator.getValue());
            Operation operation = (Operation) clazz.getDeclaredConstructor(BigDecimal.class, BigDecimal.class)
                    .newInstance(operandOne, operandTwo);
            operation.calculate();
            OperationDTO operationDTO = mapper.map(operation, OperationDTO.class);
            return operationDTO;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException e) {
            log.error(e.getLocalizedMessage());
            throw new CustomException();
        }
    }
}
