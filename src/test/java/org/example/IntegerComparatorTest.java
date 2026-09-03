package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("====== Tests for the IntegerComparator class ======")
public class IntegerComparatorTest {
    @ParameterizedTest
    @CsvSource({
            "5, 3, true",
            "-3, -5, true",
            "5, -3, true",
            "5, 0, true",
            "0, -5, true",
            "2147483647, -2147483648, true",
            "2147483647, 0, true",
            "0, -2147483648, true"
    })
    @DisplayName("compare() should return true when a > b")
    void compare_WhenAGreaterThanB_ShouldReturnTrue(int a, int b, boolean expected) {
        assertEquals(expected, IntegerComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5, false",
            "-5, -3, false",
            "-5, 3, false",
            "0, 5, false",
            "-5, 0, false",
            "-2147483648, 2147483647, false",
            "0, 2147483647, false",
            "-2147483648, 0, false"
    })
    @DisplayName("compare() should return false when a < b")
    void compare_WhenALessThanB_ShouldReturnFalse(int a, int b, boolean expected) {
        assertEquals(expected, IntegerComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, false",
            "-5, -5, false",
            "0, 0, false",
            "2147483647, 2147483647, false",
            "-2147483648, -2147483648, false"
    })
    @DisplayName("compare() should return false when a == b")
    void compare_WhenAEqualsB_ShouldReturnFalse(int a, int b, boolean expected) {
        assertEquals(expected, IntegerComparator.compare(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 2147483646, true",
            "-2147483647, -2147483648, true",
            "2147483646, 2147483647, false",
            "-2147483648, -2147483647, false"
    })
    @DisplayName("compare() should handle boundary values correctly")
    void compare_WithBoundaryValues_ShouldReturnCorrectResult(int a, int b, boolean expected) {
        assertEquals(expected, IntegerComparator.compare(a, b));
    }
}
