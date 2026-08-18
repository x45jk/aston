package org.example;

interface Figure {
    default double calculatePerimeter(double width, double height) { return 2 * (width + height); }
    default double calculateArea(double width, double height)      { return width * height; }
    default void printInfo(double perimeter, double area, String fillColor, String borderColor) {
        System.out.println("  Периметр:    " + String.format("%.2f", perimeter) + "\n" +
                           "  Площадь:     " + String.format("%.2f", area) + "\n" +
                           "  Цвет фона:   " + fillColor + "\n" +
                           "  Цвет границ: " + borderColor);
    }
}
