package com.iteriam.calculator.common.enums;

public enum OperatorEnum {
    add("com.iteriam.calculator.bean.Addition"),
    sub("com.iteriam.calculator.bean.Subtraction");

    private final String value;

    OperatorEnum(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}
