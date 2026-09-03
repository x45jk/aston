package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("====== Tests for the Calculator class ======")
public class CalculatorTest {
    // positive test
    @ParameterizedTest
    @CsvSource({
            // - addition
            "2, 3, +, 5.0",
            "-4, 5, +, 1.0",
            "4, -5, +, -1.0",
            "-6, -3, +, -9.0",
            "3, 0, +, 3.0",
            "0, 7, +, 7.0",
            "0, 0, +, 0.0",
            "2147483647, 1, +, 2147483648.0",   // Integer.MAX_VALUE + 1
            // - subtraction
            "15, 3, -, 12.0",
            "-11, 5, -, -16.0",
            "13, -5, -, 18.0",
            "-4, -16, -, 12.0",
            "13, 0, -, 13.0",
            "0, -17, -, 17.0",
            "0, 0, -, 0.0",
            "-2147483648, -1, -, -2147483647.0",    // Integer.MIN_VALUE - -1
            // - multiplication
            "4, 7, *, 28.0",
            "-5, 5, *, -25.0",
            "8, -3, *, -24.0",
            "-4, -5, *, 20.0",
            "23, 0, *, 0.0",
            "0, -22, *, 0.0",
            "0, 0, *, 0.0",
            "2147483647, 2, *, 4294967294.0",   // Integer.MAX_VALUE * 2
            // - division
            "36, 3, /, 12.0",
            "25, 3, /, 8.3333",
            "-125, 5, /, -25.0",
            "81, -3, /, -27.0",
            "-49, -7, /, 7.0",
            "0, -117, /, 0.0",
            "-2147483648, 2, /, -1073741824.0"  // Integer.MIN_VALUE / 2
    })
    @DisplayName("Arithmetic operations should return correct result.")
    void arithmeticOperation_ShouldReturnCorrectResult(int a, int b, char op, double expectedResult) {
        assertEquals(expectedResult, Calculator.arithmeticOperation(a, b, op), 0.0001);
    }

    // negative testing
    @ParameterizedTest
    @CsvSource({
            "5, 0, /",
            "-5, 0, /",
            "0, 0, /",
            "2147483647, 0, /",   // Integer.MAX_VALUE / 0
            "-2147483648, 0, /"   // Integer.MIN_VALUE / 0
    })
    @DisplayName("Division by zero should throw ArithmeticException.")
    void arithmeticOperation_DivisionByZero_ShouldThrowException(int a, int b, char op) {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.arithmeticOperation(a, b, op);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456, %",
            "2, 3, ^",
            "5, 7, &",
            "10, 4, #"
    })
    @DisplayName("Unknown operator should throw IllegalArgumentException.")
    void arithmeticOperation_UnknownOperator_ShouldThrowException(int a, int b, char op) {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.arithmeticOperation(a, b, op);
        });
    }
}
