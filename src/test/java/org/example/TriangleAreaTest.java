package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("====== Tests for the TriangleArea class ======")
public class TriangleAreaTest {
    // positive testing
    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.0",
            "7, 7, 7, 21.2176",
            "5, 5, 6, 12.0",
            "4, 5, 7, 9.7979",
            "1, 1, 1, 0.4330",
            "100, 100, 100, 4330.1270"
    })
    @DisplayName("The area of a triangle must be calculated correctly.")
    void getAreaByThreeSide_ShouldReturnCorrectArea(int a, int b, int c, double expectedArea) {
        assertEquals(expectedArea, TriangleArea.getAreaByThreeSide(a, b, c), 0.001);
    }

    // negative testing
    @ParameterizedTest
    @CsvSource({
            "0, 4, 5",
            "3, 0, 5",
            "3, 4, 0",
            "0, 0, 0",
            "-1, 4, 5",
            "3, -2, 5",
            "3, 4, -3",
            "-1, -2, -3",
            "1, 2, 3",
            "12, 5, 7",
            "3, 4, 1",
            "1, 2, 4",
            "13, 5, 7",
            "3, 5, 1"
    })
    @DisplayName("A triangle with invalid sides must throw an exception.")
    void getAreaByThreeSide_WithInvalidSides_ShouldThrowException(int a, int b, int c) {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.getAreaByThreeSide(a, b, c);
        });
    }
}
