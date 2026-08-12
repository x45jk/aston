package org.example;
import java.util.concurrent.ThreadLocalRandom;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
        int a = ThreadLocalRandom.current().nextInt(-10, 21);
        int b = ThreadLocalRandom.current().nextInt(-10, 21);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println( isSumBetweenTenAndTwenty(a, b) );
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = ThreadLocalRandom.current().nextInt(-100, 101);
        int b = ThreadLocalRandom.current().nextInt(-100, 101);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println( (a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная" );
    }

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

    public static boolean isSumBetweenTenAndTwenty(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }
}