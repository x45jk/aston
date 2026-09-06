package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {
    @DataProvider(name = "validExpressions")
    public Object[][] validExpressions() {
        return new Object[][]{
            // addition
            {2, 3, '+', 5.0},
            {-4, 5, '+', 1.0},
            {4, -5, '+', -1.0},
            {-6, -3, '+', -9.0},
            {3, 0, '+', 3.0},
            {0, 7, '+', 7.0},
            {0, 0, '+', 0.0},
            {Integer.MAX_VALUE, 1, '+', 2147483648.0},      // MAX_VALUE + 1
            // subtraction
            {15, 3, '-', 12.0},
            {-11, 5, '-', -16.0},
            {13, -5, '-', 18.0},
            {-4, -16, '-', 12.0},
            {13, 0, '-', 13.0},
            {0, -17, '-', 17.0},
            {0, 0, '-', 0.0},
            {Integer.MIN_VALUE, 1, '-', -2147483649.0},     // MIN_VALUE - 1
            // multiplication
            {4, 7, '*', 28.0},
            {-5, 5, '*', -25.0},
            {8, -3, '*', -24.0},
            {-4, -5, '*', 20.0},
            {23, 0, '*', 0.0},
            {0, -22, '*', 0.0},
            {0, 0, '*', 0.0},
            {Integer.MAX_VALUE, 2, '*', 4294967294.0},      // MAX_VALUE * 2
            // division
            {36, 3, '/', 12.0},
            {25, 3, '/', 8.3333},
            {-125, 5, '/', -25.0},
            {81, -3, '/', -27.0},
            {-49, -7, '/', 7.0},
            {0, -117, '/', 0.0},
            {Integer.MIN_VALUE, 2, '/', -1073741824.0}      // MIN_VALUE / 2
        };
    }

    @DataProvider(name = "divisionByZero")
    public Object[][] divisionByZero() {
        return new Object[][]{
            {5, 0, '/'},
            {-5, 0, '/'},
            {0, 0, '/'},
            {Integer.MAX_VALUE, 0, '/'},        // MAX_VALUE / 0
            {Integer.MIN_VALUE, 0, '/'}         // MIN_VALUE / 0
        };
    }

    @DataProvider(name = "unknownOperators")
    public Object[][] unknownOperators() {
        return new Object[][]{
            {123, 456, '%'},
            {2, 3, '^'},
            {5, 7, '&'},
            {10, 4, '#'}
        };
    }

    // positive test
    @Test(dataProvider = "validExpressions",
          description = "Arithmetic operations should return correct result.")
    public void arithmeticOperation_ShouldReturnCorrectResult(int a, int b, char op, double expectedResult) {
        assertEquals(Calculator.arithmeticOperation(a, b, op), expectedResult, 0.0001);
    }

    // negative testing
    @Test(dataProvider = "divisionByZero",
          expectedExceptions = ArithmeticException.class,
          description = "Division by zero should throw ArithmeticException.")
    public void arithmeticOperation_DivisionByZero_ShouldThrowException(int a, int b, char op) {
        Calculator.arithmeticOperation(a, b, op);
    }

    @Test(dataProvider = "unknownOperators",
          expectedExceptions = IllegalArgumentException.class,
          description = "Unknown operator should throw IllegalArgumentException.")
    public void arithmeticOperation_UnknownOperator_ShouldThrowException(int a, int b, char op) {
        Calculator.arithmeticOperation(a, b, op);
    }
}