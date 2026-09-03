package org.example;

public class Calculator {
    public static double arithmeticOperation(int a, int b, char op) {
        switch (op) {
            case '+':
                return (double) a + b;
            case '-':
                return (double) a - b;
            case '*':
                return (double) a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is impossible.");
                }
                return (double) a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op + ". Supported operators: +, -, *, /");
        }
    }
}