package com.iteriam.calculator.controller;

import com.iteriam.calculator.common.enums.OperatorEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BasicOperationControllerParamsIntTest {

    @Autowired
    private MockMvc mockMvc;

    private OperatorEnum operator;

    @BeforeEach
    void setOperator() {
        operator = OperatorEnum.add;
    }

    @Test
    void basicOperationController_operationWithOperands_IsOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator)
                .param("op1", "1")
                .param("op2", "2"))
                .andExpect(status().isOk());
    }

    @Test
    void basicOperationController_operationWithNoOperands_returnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator))
                .andExpect(status().isBadRequest());
    }

    @Test
    void basicOperationController_operationWithJustOneOperands_returnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator)
                .param("op1", "1"))
                .andExpect(status().isBadRequest());
    }

}
