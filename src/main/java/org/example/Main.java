package org.example;
import java.util.ArrayList;
import java.lang.reflect.Field;
/*
1. Каждая программа - отдельный класс?
2.
 */

public class Main {
    public static void main(String[] args) {
        // factorial
        int[] numbers = {0, 1, 2, 3, 20, 21, -1, Integer.MIN_VALUE};

        for (int n : numbers) {
            try {
                long result = Factorial.calculate(n);
                System.out.printf("%d! = %,d%n", n, result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // triangle area
    }
}