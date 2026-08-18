package org.example;

class Rectangle implements Figure {
    private final double width;
    private final double height;
    private final String fillColor;
    private final String borderColor;
    private final double perimeter;
    private final double area;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.perimeter = calculatePerimeter(this.width, this.height);
        this.area = calculateArea(this.width, this.height);
    }

    public void printRectangleInfo() {
        System.out.println("Характеристики прямоугольника:");
        printInfo(perimeter, area, fillColor, borderColor);
    }
}
