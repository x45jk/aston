package org.example;

class Product {
    private final String productName;
    private final String manufactureDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final double price;
    private final boolean isReserved;

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
