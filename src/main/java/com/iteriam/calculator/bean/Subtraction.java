package com.iteriam.calculator.bean;

import com.iteriam.calculator.common.enums.OperatorEnum;
import java.math.BigDecimal;

public class Subtraction extends Operation {

    public Subtraction() {
        super();
        operator = OperatorEnum.sub;
    }

    public Subtraction(BigDecimal operandOne) {
        super(operandOne);
        operator = OperatorEnum.sub;
    }

    public Subtraction(BigDecimal operandOne, BigDecimal operandTwo) {
        super(operandOne, operandTwo);
        operator = OperatorEnum.sub;
    }


    @Override
    public Operation calculate() {
        result = operandOne.subtract(operandTwo);
        return this;
    }

}
