package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {
    @Test
    void factorialOfZero_ShouldReturnOne() {
        assertEquals(1L, Factorial.calculate(0));
    }

    @Test
    void factorialOfOne_ShouldReturnOne() {
        assertEquals(1L, Factorial.calculate(1));
    }

    @Test
    void factorialOfTwo_ShouldReturnTwo() {
        assertEquals(2L, Factorial.calculate(2));
    }

    @Test
    void factorialOfThree_ShouldReturnSix() {
        assertEquals(6L, Factorial.calculate(3));
    }

    @Test
    void factorialOf20_ShouldReturn2432902008176640000() {
        assertEquals(2432902008176640000L, Factorial.calculate(20));
    }

    @Test
    void factorialOf21_ShouldThrowExceptionDueToOverflow() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(21);
        });
    }

    @Test
    void factorialOfNegativeOne_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-1);
        });
    }

    @Test
    void factorialOfMinInt_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(Integer.MIN_VALUE);
        });
    }
}
