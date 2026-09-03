package org.example;

public class Main {
    public static void main(String[] args) {
        // factorial
/*        int[] numbers = {0, 1, 2, 3, 20, 21, -1, Integer.MIN_VALUE};

        for (int n : numbers) {
            try {
                long result = Factorial.calculate(n);
                System.out.printf("%d! = %,d%n", n, result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }*/

        // triangle area
/*        int[][] triangles = {
                // positive testing
                {3, 4, 5},          // right triangle
                {7, 7, 7},          // equilateral triangle
                {5, 5, 6},          // isosceles triangle
                {4, 5, 7},          // scalene triangle
                {1, 1, 1},          // mininal values
                {100, 100, 100},    // large values
                // negative testing
                {0, 4, 5},          // one side is equal 0
                {3, 0, 5},              // second side is equal 0
                {3, 4, 0},              // third side is equal 0
                {0, 0, 0},              // all sides are equal 0
                {-1, 4, 5},         // one side is a negative number
                {3, -2, 5},             // second side is a negative number
                {3, 4, -3},             // third side is a negative number
                {-1, -2, -3},           // all sides are a negative number
                {1, 2, 3},          // a + b == c
                {12, 5, 7},             // b + c == a
                {3, 4, 1},              // a + c == b
                {1, 2, 4},          // a + b < c
                {13, 5, 7},             // b + c < a
                {3, 5, 1},              // a + c < b
        };

        for (int[] sides : triangles) {
            int a = sides[0];
            int b = sides[1];
            int c = sides[2];

            try {
                double area = TriangleArea.getAreaByThreeSide(a, b, c);
                System.out.printf("Triangle (%d, %d, %d) area = %.3f%n", a, b, c, area);
            } catch (IllegalArgumentException e) {
                System.out.printf("Triangle (%d, %d, %d) Error: %s%n", a, b, c, e.getMessage());
            }
        }*/

        // calculator
/*        Object[][] expressions = new Object[][]{
                // positive testing
                // - addition
                {2, 3, '+', 5.0},         // a + b
                {-4, 5, '+', 1.0},        // -a + b
                {4, -5, '+', -1.0},       // a + -b
                {-6, -3, '+', -9.0},      // -a + -b
                {3, 0, '+', 3.0},         // a + 0
                {0, 7, '+', 7.0},         // 0 + b
                {0, 0, '+', 0.0},         // 0 + 0
                {Integer.MAX_VALUE, 1, '+', 2147483648.0},   // Integer.MAX_VALUE + 1
                // - subtraction
                {15, 3, '-', 12.0},       // a - b
                {-11, 5, '-', -16.0},     // -a - b
                {13, -5, '-', 18.0},      // a - -b
                {-4, -16, '-', 12.0},     // -a - -b
                {13, 0, '-', 13.0},       // a - 0
                {0, -17, '-', 17.0},      // 0 - -b
                {0, 0, '-', 0.0},         // 0 - 0
                {Integer.MIN_VALUE, -1, '-', -2147483647.0}, // Integer.MIN_VALUE - -1
                // - multiplication
                {4, 7, '*', 28.0},        // a * b
                {-5, 5, '*', -25.0},      // -a * b
                {8, -3, '*', -24.0},      // a * -b
                {-4, -5, '*', 20.0},      // -a * -b
                {23, 0, '*', 0.0},        // a * 0
                {0, -22, '*', 0.0},       // 0 * -b
                {0, 0, '*', 0.0},         // 0 * 0
                {Integer.MAX_VALUE, 2, '*', 4294967294.0},   // Integer.MAX_VALUE * 2
                // - division
                {36, 3, '/', 12.0},       // a / b (a % b == 0)
                {25, 3, '/', 8.3333},     // a / b (a % b != 0)
                {-125, 5, '/', -25.0},    // -a / b
                {81, -3, '/', -27.0},     // a / -b
                {-49, -7, '/', 7.0},      // -a / -b
                {0, -117, '/', 0.0},      // 0 / -b
                {Integer.MIN_VALUE, 2, '/', -1073741824.0}, // Integer.MIN_VALUE / 2
                // negative testing
                {5, 0, '/', null},          // division by zero
                {123, 456, '%', null}       // unknown operator
        };

        for (Object[] exp : expressions) {
            int a = (int) exp[0];
            int b = (int) exp[1];
            char op = (char) exp[2];
            Double expectedResult = (Double) exp[3];

            try {
                double result = Calculator.arithmeticOperation(a, b, op);

                if (expectedResult != null) {
                    System.out.printf("%d %c %d = %.2f (expected: %.2f)%n",
                            a, op, b, result, expectedResult);
                } else {
                    System.out.printf("%d %c %d = %.2f (expected: Exception)%n",
                            a, op, b, result);
                }

            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.printf("%d %c %d = Error: %s%n",
                        a, op, b, e.getMessage());
            }
        }*/

        // comparator
/*        Object[][] testData = {
            // positive testing
            // - a > b
            {5, 3, true},           // positive numbers
            {-3, -5, true},         // negative numbers (closer to zero)
            {5, -3, true},          // positive > negative
            {5, 0, true},           // positive > 0
            {0, -5, true},          // 0 > negative
            {Integer.MAX_VALUE, Integer.MIN_VALUE, true}, // MAX > MIN
            {Integer.MAX_VALUE, 0, true},       // MAX > 0
            {0, Integer.MIN_VALUE, true},       // 0 > MIN
            // - a < b
            {3, 5, false},                      // positive numbers
            {-5, -3, false},                    // negative numbers (further from zero)
            {-5, 3, false},                     // negative < positive
            {0, 5, false},                      // 0 < positive
            {-5, 0, false},                     // negative < 0
            {Integer.MIN_VALUE, Integer.MAX_VALUE, false}, // MIN < MAX
            {0, Integer.MAX_VALUE, false},      // 0 < MAX
            {Integer.MIN_VALUE, 0, false},      // MIN < 0
            // - a == b
            {5, 5, false},                      // equal positive
            {-5, -5, false},                    // equal negative
            {0, 0, false},                      // zero and zero
            {Integer.MAX_VALUE, Integer.MAX_VALUE, false}, // MAX == MAX
            {Integer.MIN_VALUE, Integer.MIN_VALUE, false}, // MIN == MIN
            // - boundary values
            {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, true},  // MAX > MAX-1
            {Integer.MIN_VALUE + 1, Integer.MIN_VALUE, true},  // MIN+1 > MIN
            {Integer.MAX_VALUE - 1, Integer.MAX_VALUE, false}, // MAX-1 < MAX
            {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, false}, // MIN < MIN+1
        };

        System.out.println("\n=== Testing compare(a, b) ===");
        for (Object[] data : testData) {
            int a = (int) data[0];
            int b = (int) data[1];
            boolean expected = (boolean) data[2];
            boolean actual = IntegerComparator.compare(a, b);

            System.out.printf("%d > %d = %-5b (expected: %-5b)%n", a, b, actual, expected);
        }*/
    }
}