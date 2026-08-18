package org.example;

class Animal {
    private final String name;
    private final int runLimit;
    private final int swimLimit;
    private static int numberOfAnimals = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        numberOfAnimals++;
    }

    public String getName()            { return name; }
    public int    getNumberOfAnimals() { return numberOfAnimals; }

    public void run(int distance) {
        if (runLimit == 0)
            System.out.println(name + " не умеет бегать.");
        else if (distance <= 0)
            System.out.println(name + " не может пробежать " + distance + " м.");
        else if(distance <= runLimit)
            System.out.println(name + " пробежал(а) "  + distance + " м.");
        else if (distance > runLimit)
            System.out.println(name + " пробежал(а) "  + runLimit + " м и остановился(-ась).");
    }

    public void swim(int distance) {
        if (swimLimit == 0)
            System.out.println(name + " не умеет плавать.");
        else if (distance <= 0)
            System.out.println(name + " не может проплыть " + distance + " м.");
        else if (distance <= swimLimit)
            System.out.println(name + " проплыл(а) "  + distance + " м.");
        else if (distance > swimLimit)
            System.out.println(name + " проплыл(а) "  + swimLimit + " м и остановился(-ась).");
    }
}
