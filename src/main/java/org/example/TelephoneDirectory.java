package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {
    private final HashMap<String, ArrayList<String>> hm = new HashMap<>();

    /*
    первая попытка была создание 'add(String phoneNumber, String lastName)' с уникальным 'phoneNumber',
    но пообщавшись с ИИшкой передумал,
    возможно зря
     */

    public void add(String lastName, String phoneNumber) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

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
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }

        if (hm.containsKey(lastName)) {
            System.out.println("Phone numbers for '" + lastName + "':");
            for (String number : hm.get(lastName))
                System.out.println("- " + number);
        } else
            System.out.println("Person with the lastname '" + lastName + "' was not found.");
    }
}
