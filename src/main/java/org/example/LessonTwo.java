package org.example;

public class LessonTwo {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.2 =====");
        // I-е задание
        System.out.println("--- Задание №1 ---");
        System.out.println("[Класс 'Product' создан]");
    }
}

// I-е задание
class Product{
    private String productName;
    private String manufactureDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    Product(String productName, String manufactureDate, String manufacturer,
            String countryOfOrigin, double price, boolean isReserved) {
        this.productName = productName;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    void printInfoAboutProduct() {
        System.out.println("Название:                 " + productName);
        System.out.println("Дата производства:        " + manufactureDate);
        System.out.println("Производитель:            " + manufacturer);
        System.out.println("Страна происхождения:     " + countryOfOrigin);
        System.out.println("Цена:                     " + price);
        System.out.println("Забронирован покупателем: " + (isReserved ? "Да" : "Нет"));
    }
}