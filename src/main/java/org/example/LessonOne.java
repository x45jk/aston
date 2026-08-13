package org.example;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class LessonOne {
    public static void main(String[] args) {
        int a, b, size;
        int[] arr;

        System.out.println("===== Домашнее задание к Лекции 2.2 =====");
        // I-е задание
        System.out.println("--- Задание №1 ---");
        printThreeWords();

        // II-е задание
        System.out.println("\n--- Задание №2 ---");
        checkSumSign();

        // III-е задание
        System.out.println("\n--- Задание №3 ---");
        printColor();

        // IV-е задание
        System.out.println("\n--- Задание №4 ---");
        compareNumbers();

        // V-е задание
        System.out.println("\n--- Задание №5 ---");
        a = ThreadLocalRandom.current().nextInt(-10, 21);
        b = ThreadLocalRandom.current().nextInt(-10, 21);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println( isSumBetweenTenAndTwenty(a, b) );

        // VI-е задание
        System.out.println("\n--- Задание №6 ---");
        a = ThreadLocalRandom.current().nextInt(-10, 11);

        System.out.println("a = " + a);

        checkNumber(a);

        // VII-е задание
        System.out.println("\n--- Задание №7 ---");
        a = ThreadLocalRandom.current().nextInt(-10, 11);

        System.out.println("a = " + a);

        if (isNumberNegative(a))
            System.out.println("Да, ввели отрицательное число");
        else
            System.out.println("Нет, ввели положительное число");

        // VIII-е задание
        System.out.println("\n--- Задание №8 ---");
        String str = "Lorem ipsum dolor sit amet ";
        int count = ThreadLocalRandom.current().nextInt(0, 11);

        System.out.println("str = \"" + str + "\"");
        System.out.println("count = " + count);

        printStringNTimes(str, count);

        // IX-е задание
        System.out.println("\n--- Задание №9 ---");
        int year = ThreadLocalRandom.current().nextInt(0, 3000);

        System.out.println("Year " + year +
                           ( isLeapYear(year) ? " is " : " isn't " ) +
                           "leap.");

        // X-е задание
        System.out.println("\n--- Задание №10 ---");
        int num = ThreadLocalRandom.current().nextInt(0, 1024);
        arr = new int[10];

        for (int i = 9; i >= 0; i--) {
            arr[i] = num % 2;    // младший бит
            num = num / 2;      // сдвигаем вправо
        }

        System.out.println("Array:        " + Arrays.toString(arr));
        System.out.println("Converted to: " + Arrays.toString( invertBits(arr) ));

        // XI-е задание
        System.out.println("\n--- Задание №11 ---");
        size = 100;

        arr = new int[size];

        System.out.println("Array:        " + Arrays.toString(arr));
        System.out.println("Converted to: " + Arrays.toString( fillArrayFrom1To100(arr) ));

        // XII-е задание
        System.out.println("\n--- Задание №12 ---");
        int[] tempArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Array:        " + Arrays.toString(tempArr));
        System.out.println("Converted to: " + Arrays.toString( multiplyValuesLessThanSix(tempArr) ));

        // XIII-е задание
        System.out.println("\n--- Задание №13 ---");
        size = ThreadLocalRandom.current().nextInt(2, 20);
        int[][] matrix = new int[size][size];

        System.out.println("Size: " + size);
        System.out.println("Array: ");
        printMatrix(matrix);

        fillDiagonal(matrix);

        System.out.println("Converted to: ");
        printMatrix(matrix);

        // XIV-е задание
        System.out.println("\n--- Задание №14 ---");
        int len = ThreadLocalRandom.current().nextInt(1, 20);
        char initialValue = (char)ThreadLocalRandom.current().nextInt(33, 127);

        System.out.println("Размер массива:     " + len);
        System.out.println("Начальное значение: " + initialValue);
        System.out.println("Created array:      " + Arrays.toString( createArrayAndFill(len, initialValue) ));
    }

    // I-е задание
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // II-е задание
    public static void checkSumSign() {
        int a = ThreadLocalRandom.current().nextInt(-100, 101);
        int b = ThreadLocalRandom.current().nextInt(-100, 101);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println( (a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная" );
    }

    // III-е задание
    public static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(-100, 201);

        System.out.println("value = " + value);

        if (value <= 0)
            System.out.println("Красный");
        else if (value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    // IV-е задание
    public static void compareNumbers() {
        int a = ThreadLocalRandom.current().nextInt(-100, 101);
        int b = ThreadLocalRandom.current().nextInt(-100, 101);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    // V-е задание
    public static boolean isSumBetweenTenAndTwenty(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    // VI-е задание
    public static void checkNumber(int a) {
        System.out.println("Передали " +
                           (a < 0 ? "отрицательное" : "положительное") +
                           " число");
    }

    // VII-е задание
    public static boolean isNumberNegative(int a) {
        return a < 0;
    }

    // VIII-е задание
    public static void printStringNTimes(String str, int count) {
        for (int i = 0; i < count; i++)
            System.out.print(str);

        if (count != 0)
            System.out.println();
    }

    // IX-е задание
    public static boolean isLeapYear(int year) {
        boolean leapYear = false;

        if (year % 4 == 0 && year % 100 != 0)
            leapYear = true;
        else if (year % 100 == 0 && year % 400 == 0)
            leapYear = true;

        return leapYear;
    }

    // X-е задание
    public static int[] invertBits(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0) result[i] = 1;
            else result[i] = 0;

        return result;
    }

    // XI-е задание
    public static int[] fillArrayFrom1To100(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            result[i] = i + 1;

        return result;
    }

    // XII-е задание
    public static int[] multiplyValuesLessThanSix(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                result[i] = arr[i] * 2;
            else
                result[i] = arr[i];

        return result;
    }

    // XIII-е задание
    public static void fillDiagonal(int[][] matrix) {
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
                matrix[i][i] = 1;
                matrix[i][size - i - 1] = 1;
        }
    }

    // XIII-е задание (доп)
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // XIV-е задание
    public static char[] createArrayAndFill(int len, char initialValue) {
        char[] result = new char[len];

        // Arrays.fill(result, initialValue);
        for (int i = 0; i < len; i++)
            result[i] = initialValue;

        return result;
    }
}