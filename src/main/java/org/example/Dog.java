package org.example;

final class Dog extends Animal {
    private static int numberOfDogs = 0;

    public Dog(String name) {
        super(name, 500, 10);
        numberOfDogs++;
    }

    public int getNumberOfDogs() {
        return numberOfDogs;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
    }
}
