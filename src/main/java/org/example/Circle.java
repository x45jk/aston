package org.example;

class Circle implements Figure {
    private final double radius;
    private final String fillColor;
    private final String borderColor;
    private double perimeter;
    private double area;
    private final double PI = Math.PI;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;

        calculatePerimeter();
        calculateArea();
    }

    private void calculatePerimeter() { perimeter = 2 * PI * radius; }
    private void calculateArea()      { area = PI * radius * radius; }

    public void printCircleInfo() {
        System.out.println("Характеристики круга:");
        printInfo(perimeter, area, fillColor, borderColor);
    }
}
