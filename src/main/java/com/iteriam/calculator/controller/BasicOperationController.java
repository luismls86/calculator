package com.iteriam.calculator.controller;

import com.iteriam.calculator.common.enums.OperatorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/basic-operation/")
public class BasicOperationController {

    @GetMapping(
            path = "/{operator}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<> operate(@PathVariable("operator") OperatorEnum operator,
                                          @RequestParam("op1") BigDecimal operandOne,
                                          @RequestParam("op2") BigDecimal operandTwo) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
