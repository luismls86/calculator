package com.iteriam.calculator.controller;

import com.iteriam.calculator.common.exception.CustomException;
import com.iteriam.calculator.common.enums.OperatorEnum;
import com.iteriam.calculator.service.BasicOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/basic-operation/")
public class BasicOperationController {

    @Autowired
    BasicOperationService basicOperationService;

    @GetMapping(
            path = "/{operator}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<BigDecimal> operate(@PathVariable("operator") OperatorEnum operator,
                                          @RequestParam("op1") BigDecimal operandOne,
                                          @RequestParam("op2") BigDecimal operandTwo) {
        try {
            BigDecimal result = basicOperationService.operate(operator, operandOne, operandTwo);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
