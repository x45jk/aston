package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTest {
    @DataProvider(name = "validTriangles")
    public Object[][] validTriangles() {
        return new Object[][]{
            {3, 4, 5, 6.0},
            {7, 7, 7, 21.2176},
            {5, 5, 6, 12.0},
            {4, 5, 7, 9.7979},
            {1, 1, 1, 0.4330},
            {100, 100, 100, 4330.1270}
        };
    }

    @DataProvider(name = "invalidTriangles")
    public Object[][] invalidTriangles() {
        return new Object[][]{
            {0, 4, 5},
            {3, 0, 5},
            {3, 4, 0},
            {0, 0, 0},
            {-1, 4, 5},
            {3, -2, 5},
            {3, 4, -3},
            {-1, -2, -3},
            {1, 2, 3},
            {12, 5, 7},
            {3, 4, 1},
            {1, 2, 4},
            {13, 5, 7},
            {3, 5, 1}
        };
    }

    // positive tests
    @Test(dataProvider = "validTriangles",
          description = "The area of a triangle must be calculated correctly.")
    public void getAreaByThreeSide_ShouldReturnCorrectArea(int a, int b, int c, double expectedArea) {
        assertEquals(TriangleArea.getAreaByThreeSide(a, b, c), expectedArea, 0.001);
    }

    // negative tests
    @Test(dataProvider = "invalidTriangles",
          expectedExceptions = IllegalArgumentException.class,
          description = "A triangle with invalid sides must throw an exception.")
    public void getAreaByThreeSide_WithInvalidSides_ShouldThrowException(int a, int b, int c) {
        TriangleArea.getAreaByThreeSide(a, b, c);
    }
}