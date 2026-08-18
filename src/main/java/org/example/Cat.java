package org.example;

public class Cat extends Animal {
    protected static int numberOfCats = 0;

    public Cat(String name) {
        super(name);
        runLimit = 200;
        swimLimit = 0;
        numberOfCats++;
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
        System.out.println(name + " не умеет плавать.");
    }
}
