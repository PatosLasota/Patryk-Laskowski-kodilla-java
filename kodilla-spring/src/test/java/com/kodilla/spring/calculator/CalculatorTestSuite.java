package com.kodilla.spring.calculator;

import com.kodilla.spring.calculator.config.CalculatorConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorConfig.class)
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd(){
        double addResult = calculator.add(5.0,5.0);
        assertEquals(10,addResult);
    }
    @Test
    public void testSubtract(){
        double result = calculator.subtract(5.0,5.0);
        assertEquals(0,result);
    }
    @Test
    public void testMultiply(){
        double result = calculator.multiply(5.0,5.0);
        assertEquals(25,result);
    }
    @Test
    public void testDivide(){
        double result = calculator.divide(5.0,5.0);
        assertEquals(1,result);
    }
}
