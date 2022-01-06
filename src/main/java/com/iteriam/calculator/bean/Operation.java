package com.iteriam.calculator.bean;

import com.iteriam.calculator.common.enums.OperatorEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public abstract class Operation implements Serializable {
    protected BigDecimal operandOne;
    protected BigDecimal operandTwo;
    protected OperatorEnum operator;
    protected BigDecimal result;

    public Operation() {
        operandOne = new BigDecimal(0);
        operandTwo = new BigDecimal(0);
    }
    
    public Operation(BigDecimal operandOne) {
        this.operandOne = operandOne;
        this.operandTwo = new BigDecimal(0);
    }

    public Operation(BigDecimal operandOne, BigDecimal operandTwo) {
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
    };

    public abstract Operation calculate();

    @Override
    public String toString() {
        return "Operation{" +
                "operandOne=" + operandOne +
                ", operandTwo=" + operandTwo +
                ", result=" + result +
                '}';
    }
}
