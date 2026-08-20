package org.example;

class Triangle implements Figure {
    private final double sideOne;
    private final double sideTwo;
    private final double sideThree;
    private final String fillColor;
    private final String borderColor;
    private double perimeter;
    private double area;

    public Triangle(double sideOne, double sideTwo, double sideThree, String fillColor, String borderColor) {
        if (sideOne <= 0 || sideTwo <= 0 || sideThree <= 0)
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами.");

        if (sideOne >= sideTwo + sideThree || sideTwo >= sideOne + sideThree || sideThree >= sideOne + sideTwo) {
            throw new IllegalArgumentException(String.format("Треугольник со сторонами %.2f-%.2f-%.2f не может существовать.",
                                               sideOne, sideTwo, sideThree));
        }

        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        this.fillColor = fillColor;
        this.borderColor = borderColor;

        calculatePerimeterByThreeSide();
        calculateAreaByThreeSide();
    }

    private void calculatePerimeterByThreeSide() { perimeter = sideOne + sideTwo + sideThree; }
    private void calculateAreaByThreeSide() {
        double sp = perimeter / 2;
        area = Math.sqrt(sp * (sp - sideOne) * (sp - sideTwo) * (sp - sideThree));
    }

    public void printTriangleInfo() {
        System.out.println("Характеристики треугольника:");
        printInfo(perimeter, area, fillColor, borderColor);
    }
}