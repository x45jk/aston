package org.example;

public class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected static int numberOfAnimals = 0;

    public Animal(String name) {
        this.name = name;
        numberOfAnimals++;
    }
}
