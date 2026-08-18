package org.example;

public class Cat extends Animal {
    private static int numberOfCats = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        runLimit = 200;
        swimLimit = 0;
        numberOfCats++;
        isFull = false;
    }

    public void run(int distance) {
        if (distance <= 0)
            System.out.println(name + " не может пробежать " + distance + " м.");
        else if (distance <= runLimit)
            System.out.println(name + " пробежал(а) "  + distance + " м.");
        else if (distance > runLimit)
            System.out.println(name + " пробежал(а) "  + runLimit + " м и остановился(-ась).");
    }

    public void swim() {
        System.out.println(name + " не умеет плавать.");
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public int getNumberOfCats() {
        return numberOfCats;
    }

    public void eat(int unitsOfFoodToEat, Bowl bowl) {
        if(unitsOfFoodToEat <= bowl.getVolumeOfFoodInBowl()) {
            isFull = true;
            System.out.println(name + " наелся(-ась) на " + unitsOfFoodToEat + " единиц еды.");
            bowl.reduceContentsOfBowl(unitsOfFoodToEat);
        } else
            System.out.println(name + " отказался(-ась) есть. Он(а) хотел(а) поесть " +
                               unitsOfFoodToEat + " единиц еды, но в миске лишь " +
                               bowl.getVolumeOfFoodInBowl() + " единиц.");
    }
}
