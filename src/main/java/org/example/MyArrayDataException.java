package org.example;

// unchecked exception
public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int x, int y) {
        super("There is incorrect data in cell [" + (x+1) + ", " + (y+1) + "]." );
    }
}