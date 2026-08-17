package org.example;
import java.util.ArrayList;

class Park {
    private final String parkName;
    private final ArrayList<Attraction> attractions;

    Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    private class Attraction {
         private final String attractionName;
         private final String workingHours;
         private final double price;

        Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        String getAttractionName() { return attractionName; }
        String getWorkingHours()   { return workingHours; }
        double getPrice()          { return price; }
    }

    public void addAttraction(String attractionName, String workingHours, double price) {
        attractions.add( new Attraction(attractionName, workingHours, price) );
    }

    public void printAttractions() {
        System.out.println("Название парка: " + this.parkName);
        System.out.println("Список аттракционов: ");
        for (var x : attractions) {
            System.out.printf("- %s\n  Время работы: %s\n  Цена билета:  %.2f\n",
                              x.getAttractionName(), x.getWorkingHours(), x.getPrice());
        }
    }
}