package org.example;

public class Factorial {
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number must be positive or equal to zero. (you sent " + n + ")");
        }
        if (n > 20) {
            throw new IllegalArgumentException("The maximum value is 20. (you sent " + n + ")");
        }

        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
