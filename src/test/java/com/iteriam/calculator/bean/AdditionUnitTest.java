package com.iteriam.calculator.bean;

import com.iteriam.calculator.common.enums.OperatorEnum;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdditionUnitTest {

    @Test
    void addition_createBeanOneOperand_returnBeanCreatedWithNoOpAttribute() {
        Operation operation = new Addition();
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(0));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getResult() == null);

    }

    @Test
    void addition_createBeanOneOperand_returnBeanCreatedWithOneOpAttribute() {
        Operation operation = new Addition(new BigDecimal(1));
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(1));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getResult() == null);

    }

    @Test
    void addition_createBeanTwoOperands_returnBeanCreatedWithTwoOpAttribute() {
        Operation operation = new Addition(new BigDecimal(1), new BigDecimal(3.44));
        assertThat(operation != null);
        assertThat(operation.getOperandOne().equals(1));
        assertThat(operation.getOperandTwo().equals(3.44));
        assertThat(operation.getResult() == null);
    }

    @Test
    void addition_createBeanAddition_returnBeanCreatedAsAdd() {
        Operation operation = new Addition(new BigDecimal(1), new BigDecimal(2));
        assertThat(operation.operator.equals(OperatorEnum.add));
    }

    @Test
    void addition_calculateResult_returnCompleteObjectWithResult() {
        Operation operation = new Addition(new BigDecimal(-1), new BigDecimal(-2));
        operation.calculate();
        assertThat(operation.getOperandOne().equals(-1));
        assertThat(operation.getOperandTwo().equals(-2));
        assertThat(operation.getOperator().equals(OperatorEnum.add));
        assertThat(operation.getResult().equals(-3));
    }

    @Test
    void addition_calculateResultWithOneOperand_returnCompleteObjectWithResult() {
        Operation operation = new Addition(new BigDecimal(6));
        operation.calculate();
        assertThat(operation.getOperandOne().equals(6));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getOperator().equals(OperatorEnum.add));
        assertThat(operation.getResult().equals(6));
    }

    @Test
    void addition_calculateResultWithNoOperand_returnCompleteObjectWithResult() {
        Operation operation = new Addition();
        operation.calculate();
        assertThat(operation.getOperandOne().equals(0));
        assertThat(operation.getOperandTwo().equals(0));
        assertThat(operation.getOperator().equals(OperatorEnum.add));
        assertThat(operation.getResult().equals(0));
    }
}
