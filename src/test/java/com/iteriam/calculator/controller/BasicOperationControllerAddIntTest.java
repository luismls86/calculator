package com.iteriam.calculator.controller;

import com.iteriam.calculator.common.enums.OperatorEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BasicOperationControllerAddIntTest {

    @Autowired
    private MockMvc mockMvc;

    private OperatorEnum operator;

    @BeforeEach
    void setOperator() {
        operator = OperatorEnum.add;
    }

    @Test
    void basicOperationController_operationAddWithPositiveOperands_returnCorrectAddition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator)
                .param("op1", "1")
                .param("op2", "6")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operandOne").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operandTwo").value("6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value(operator.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("7"));
    }

    @Test
    void basicOperationController_operationAddWithNegativeOperands_returnCorrectAddition() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator)
                .param("op1", "-1")
                .param("op2", "-6")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operandOne").value("-1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operandTwo").value("-6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value(operator.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("-7"));
    }

}
