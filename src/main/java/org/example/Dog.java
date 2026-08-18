package org.example;

public class Dog extends Animal {
    private static int numberOfDogs = 0;

    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
        numberOfDogs++;
    }

    public void run(int distance) {
        if (distance <= 0)
            System.out.println(name + " не может пробежать " + distance + " м.");
        else if(distance <= runLimit)
            System.out.println(name + " пробежал(а) "  + distance + " м.");
        else if (distance > runLimit)
            System.out.println(name + " пробежал(а) "  + runLimit + " м и остановился(-ась).");
    }

    public void swim(int distance) {
        if (distance <= 0)
            System.out.println(name + " не может проплыть " + distance + " м.");
        else if (distance <= swimLimit)
            System.out.println(name + " проплыл(а) "  + distance + " м.");
        else if (distance > swimLimit)
            System.out.println(name + " проплыл(а) "  + swimLimit + " м и остановился(-ась).");
    }

    public int getNumberOfDogs() {
        return numberOfDogs;
    }
}
