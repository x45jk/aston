package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTests {
    @DataProvider(name = "correctData")
    public Object[][] correctData() {
        return new Object[][]{
            {0, 1L},
            {1, 1L},
            {2, 2L},
            {3, 6L},
            {20, 2432902008176640000L}
        };
    }
    @DataProvider(name = "incorrectData")
    public Object[][] incorrectData() {
        return new Object[][]{
                {-1},
                {Integer.MIN_VALUE}
        };
    }

    // positive tests
    @Test(dataProvider = "correctData",
          description = "Checking the correctness of the factorial calculation.")
    public void factorial_ShouldReturnCorrectValue(int input, long expected) {
        assertEquals(Factorial.calculate(input), expected);
    }

    // negative tests
    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "^The maximum value is 20.*",
          description = "Checking that factorial of 21 throws an exception due to long overflow.")
    public void factorialOf21_ShouldThrowExceptionDueToOverflow() {
        Factorial.calculate(21);
    }

    @Test(dataProvider = "incorrectData",
          expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "^The number must be positive or equal to zero.*",
          description = "Checking that factorial of negative numbers throws an exception.")
    public void factorialOfNegativeNumber_ShouldThrowException(int input) {
        Factorial.calculate(input);
    }
}