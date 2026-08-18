package org.example;

public class Dog extends Animal {
    protected static int numberOfDogs = 0;

    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
        numberOfDogs++;
    }

    void run(int distance) {
        if (distance <= runLimit)
            System.out.println(name + " пробежал(а) "  + distance + " м.");
        else if (distance > runLimit)
            System.out.println(name + " пробежал(а) "  + runLimit + " м и остановился передохнуть.");
        else
            System.out.println("Введено неверное значение для дистанции бега.");
    }

    void swim(int distance) {
        if (distance <= swimLimit)
            System.out.println(name + " проплыл(а) "  + distance + " м.");
        else if (distance > swimLimit)
            System.out.println(name + " проплыл(а) "  + runLimit + " м и остановился передохнуть.");
        else
            System.out.println("Введено неверное значение для дистанции заплыва.");
    }
}
