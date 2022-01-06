package com.iteriam.calculator.bean;

import com.iteriam.calculator.common.enums.OperatorEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class SubtractionUnitTest {

    @Test
    void subtraction_createBeanOneOperand_returnBeanCreatedWithNoOpAttribute() {
        Operation operation = new Subtraction();
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(0));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getResult() == null);

    }

    @Test
    void subtraction_createBeanOneOperand_returnBeanCreatedWithOneOpAttribute() {
        Operation operation = new Subtraction(new BigDecimal(1));
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(1));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getResult() == null);

    }

    @Test
    void subtraction_createBeanTwoOperands_returnBeanCreatedWithTwoOpAttribute() {
        Operation operation = new Subtraction(new BigDecimal(1), new BigDecimal(8));
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(1));
        assertThat(operation.getOperandTwo().equals(8));
        assertThat(operation.getResult() == null);
    }

    @Test
    void subtraction_createBeanSubtraction_returnBeanCreatedAsAdd() {
        Operation operation = new Subtraction(new BigDecimal(1), new BigDecimal(3));
        assertThat(operation.operator.equals(OperatorEnum.sub));
    }
    
    @Test
    void subtraction_calculateResult_returnCompleteObjectWithResult() {
        Operation operation = new Subtraction(new BigDecimal(-1), new BigDecimal(-2));
        operation.calculate();
        assertThat(operation.getOperandOne().equals(1));
        assertThat(operation.getOperandTwo().equals(-2));
        assertThat(operation.getOperator().equals(OperatorEnum.sub));
        assertThat(operation.getResult().equals(3));
    }

    @Test
    void subtraction_calculateResultWithOneOperand_returnCompleteObjectWithResult() {
        Operation operation = new Subtraction(new BigDecimal(7));
        operation.calculate();
        assertThat(operation.getOperandOne().equals(7));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getOperator().equals(OperatorEnum.sub));
        assertThat(operation.getResult().equals(7));
    }

    @Test
    void subtraction_calculateResultWithNoOperand_returnCompleteObjectWithResult() {
        Operation operation = new Subtraction();
        operation.calculate();
        assertThat(operation.getOperandOne().equals(0));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getOperator().equals(OperatorEnum.sub));
        assertThat(operation.getResult().equals(0));
    }
}
