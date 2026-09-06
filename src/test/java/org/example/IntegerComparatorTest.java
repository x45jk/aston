package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class IntegerComparatorTest {
    @DataProvider(name = "aGreaterThanB")
    public Object[][] aGreaterThanB() {
        return new Object[][]{
            {5, 3, true},
            {-3, -5, true},
            {5, -3, true},
            {5, 0, true},
            {0, -5, true},
            {Integer.MAX_VALUE, Integer.MIN_VALUE, true},
            {Integer.MAX_VALUE, 0, true},
            {0, Integer.MIN_VALUE, true}
        };
    }

    @DataProvider(name = "aLessThanB")
    public Object[][] aLessThanB() {
        return new Object[][]{
                {3, 5, false},
                {-5, -3, false},
                {-5, 3, false},
                {0, 5, false},
                {-5, 0, false},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, false},
                {0, Integer.MAX_VALUE, false},
                {Integer.MIN_VALUE, 0, false}
        };
    }

    @DataProvider(name = "aEqualsB")
    public Object[][] aEqualsB() {
        return new Object[][]{
                {5, 5, false},
                {-5, -5, false},
                {0, 0, false},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, false},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, false}
        };
    }

    @DataProvider(name = "boundaryValues")
    public Object[][] boundaryValues() {
        return new Object[][]{
                {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, true},
                {Integer.MIN_VALUE + 1, Integer.MIN_VALUE, true},
                {Integer.MAX_VALUE - 1, Integer.MAX_VALUE, false},
                {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, false}
        };
    }

    // positive tests (only)
    @Test(dataProvider = "aGreaterThanB",
            description = "compare() should return true when a > b")
    public void compare_WhenAGreaterThanB_ShouldReturnTrue(int a, int b, boolean expected) {
        assertEquals(IntegerComparator.compare(a, b), expected);
    }

    @Test(dataProvider = "aLessThanB",
            description = "compare() should return false when a < b")
    public void compare_WhenALessThanB_ShouldReturnFalse(int a, int b, boolean expected) {
        assertEquals(IntegerComparator.compare(a, b), expected);
    }

    @Test(dataProvider = "aEqualsB",
            description = "compare() should return false when a == b")
    public void compare_WhenAEqualsB_ShouldReturnFalse(int a, int b, boolean expected) {
        assertEquals(IntegerComparator.compare(a, b), expected);
    }

    @Test(dataProvider = "boundaryValues",
            description = "compare() should handle boundary values correctly")
    public void compare_WithBoundaryValues_ShouldReturnCorrectResult(int a, int b, boolean expected) {
        assertEquals(IntegerComparator.compare(a, b), expected);
    }
}