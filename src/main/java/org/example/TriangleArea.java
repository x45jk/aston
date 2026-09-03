package org.example;

public class TriangleArea {
    public static double getAreaByThreeSide(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The length of the sides of a triangle must be a positive number.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("A triangle with such sides cannot exist.");
        }

        // Heron's formula
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
