package org.example;

public class LessonTwo {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.2 =====");
        // I-е задание
        System.out.println("--- Задание №1 ---");
        System.out.println("[Класс 'Product' создан]");

        System.out.println("\n--- Задание №2 ---");
        Product[] productsArray = new Product[5];
        System.out.println("[Массив из 5 товаров создан]");
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[2] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[3] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[4] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        System.out.println("[Массив из 5 товаров заполнен]");
//        productsArray[0].printInfoAboutProduct();
    }
}