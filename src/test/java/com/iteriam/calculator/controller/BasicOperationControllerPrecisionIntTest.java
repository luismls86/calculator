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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BasicOperationControllerPrecisionIntTest {

    @Autowired
    private MockMvc mockMvc;

    private OperatorEnum operator;

    @BeforeEach
    void setOperator() {
        operator = OperatorEnum.add;
    }

    @Test
    void basicOperationController_operationWithOperandsWithHugeNumbers_returnResultWithCorrectPrecision() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                .get("/basic-operation/{operator}", operator)
                .param("op1", "443453534324234234234234234534523.242342342345645645645673453453453453453453452342")
                .param("op2", "3453453453453453453453453453523453455.353453453453453453453434534566666663453453453")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String result = response.getRequest().getContentAsString();
        assertThat(result == "3453896906987777687687687687757987978.595795795799099099099107988020120116906906905342");
    }


}
