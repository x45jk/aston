package org.example;

// checked exception
public class MyArraySizeException extends Exception {
    public MyArraySizeException()               { super("Array size must be 4x4"); }
    public MyArraySizeException(String message) { super(message); }
}
