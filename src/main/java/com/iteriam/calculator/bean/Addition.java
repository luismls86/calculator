package com.iteriam.calculator.bean;

import com.iteriam.calculator.common.enums.OperatorEnum;
import java.math.BigDecimal;

public class Addition extends Operation {

    public Addition() {
        super();
        operator = OperatorEnum.add;
    }

    public Addition(BigDecimal operandOne) {
        super(operandOne);
        operator = OperatorEnum.add;
    }

    public Addition(BigDecimal operandOne, BigDecimal operandTwo) {
        super(operandOne, operandTwo);
        operator = OperatorEnum.add;
    }

    @Override
    public Operation calculate() {
        result = operandOne.add(operandTwo);
        return this;
    }

}
