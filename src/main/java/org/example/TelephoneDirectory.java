package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {
    private final HashMap<String, ArrayList<String>> hm = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        // hm.computeIfAbsent(lastName, key -> new ArrayList<>()).add(phoneNumber);
        if (hm.containsKey(lastName))
            hm.get(lastName).add(phoneNumber);
        else {
            ArrayList<String> al = new ArrayList<>();
            al.add(phoneNumber);
            hm.put(lastName, al);
        }
    }

    public void get(String lastName) {
        if (hm.containsKey(lastName)) {
            System.out.println("Phone numbers for '" + lastName + "':");
            for (String number : hm.get(lastName))
                System.out.println("- " + number);
        } else
            System.out.println("Person with the lastname '" + lastName + "' was not found.");
    }
}
