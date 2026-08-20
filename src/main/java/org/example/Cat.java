package org.example;

final class Cat extends Animal {
    private static int numberOfCats = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        numberOfCats++;
        isFull = false;
    }

    public int getNumberOfCats() { return numberOfCats; }

    @Override
    public void run(int distance) {
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
    }

    public void eat(int unitsOfFoodToEat, Bowl bowl) {
        if (isFull)
            System.out.println(getName() + " не голоден.");
        else if(unitsOfFoodToEat <= bowl.getVolumeOfFoodInBowl()) {
            isFull = true;
            System.out.println(getName() + " наелся(-ась) на " + unitsOfFoodToEat + " единиц еды.");
            bowl.reduceContentsOfBowl(unitsOfFoodToEat);
        } else
            System.out.println(getName() + " отказался(-ась) есть. Он(а) хотел(а) поесть " +
                               unitsOfFoodToEat + " единиц еды, но в миске лишь " +
                               bowl.getVolumeOfFoodInBowl() + " единиц.");
    }
}
