package org.example;

public class Bowl {
    private int bowlVolume;
    private int volumeOfFoodInBowl;

    public Bowl (int bowlVolume) {
        this.bowlVolume = bowlVolume;
    }

    public int getBowlVolume() {
        return bowlVolume;
    }

    public int getVolumeOfFoodInBowl() {
        return volumeOfFoodInBowl;
    }

    public void addFood(int volumeOfFood) {
        if (bowlVolume == volumeOfFoodInBowl)
            System.out.println("Миска уже полная, в ней " + volumeOfFoodInBowl + " единиц еды.");
        else if ( (bowlVolume - volumeOfFoodInBowl) >= volumeOfFood) {
            volumeOfFoodInBowl += volumeOfFood;
            System.out.println("В миску добавили " + volumeOfFood + " единиц еды.");
            getBowlInfo();
        } else {
            volumeOfFoodInBowl = bowlVolume;
            System.out.println("Миска полна еды, теперь в ней " + volumeOfFoodInBowl + " единиц еды.");
        }
    }

    public void reduceContentsOfBowl(int volumeOfFood) {
        if (volumeOfFoodInBowl == volumeOfFood) {
            System.out.println("Миска пустая.");
            volumeOfFoodInBowl = 0;
        } else if (volumeOfFoodInBowl > volumeOfFood) {
            volumeOfFoodInBowl -= volumeOfFood;
            System.out.println("В миске осталось " + volumeOfFoodInBowl + " единиц еды.");
        } else if (volumeOfFoodInBowl < volumeOfFood)
            System.out.println("В миске лишь " + volumeOfFoodInBowl + " единиц еды.");
    }

    public void getBowlInfo(){
        System.out.println("(Теперь в миске " + volumeOfFoodInBowl + " единиц еды. " +
                "Свободно " + (bowlVolume - volumeOfFoodInBowl) + " единиц объёма миски.)");
    }
}
