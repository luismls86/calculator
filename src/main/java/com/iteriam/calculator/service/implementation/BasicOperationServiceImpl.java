package com.iteriam.calculator.service.implementation;

import com.iteriam.calculator.bean.Operation;
import com.iteriam.calculator.common.exception.CustomException;
import com.iteriam.calculator.service.dto.OperationDTO;
import com.iteriam.calculator.common.enums.OperatorEnum;
import com.iteriam.calculator.service.BasicOperationService;
import io.corp.calculator.TracerImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

@Service
@Slf4j
public class BasicOperationServiceImpl implements BasicOperationService {

    private ModelMapper mapper = new ModelMapper();
    private TracerImpl tracer = new TracerImpl();

    @Override
    public OperationDTO operate(OperatorEnum operator, BigDecimal operandOne, BigDecimal operandTwo) throws CustomException {

        try {
            String operationTrace = new StringBuilder()
                    .append("Operation: ")
                    .append(operandOne).append(" ")
                    .append(operator).append(" ")
                    .append(operandTwo)
                    .toString();
            log.info(operationTrace);
            Class<?> clazz = Class.forName(operator.getValue());
            Operation operation = (Operation) clazz.getDeclaredConstructor(BigDecimal.class, BigDecimal.class)
                    .newInstance(operandOne, operandTwo);
            operation.calculate();
            OperationDTO operationDTO = mapper.map(operation, OperationDTO.class);
            tracer.trace(operationDTO);
            return operationDTO;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException e) {
            log.error(e.getLocalizedMessage());
            tracer.trace(e);
            throw new CustomException();
        }
    }
}
