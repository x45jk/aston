package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.6 =====");

        // task 1
        System.out.println("\n=== Creating a collection containing objects of the Student class ===");
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Александр", "Йцук-1", 1, 4.5));
        students.add(new Student("Михаил",    "Йцук-1", 1, 2.5));
        students.add(new Student("Дмитрий",   "Фыва-2", 2, 3.2));
        students.add(new Student("София",     "Фыва-2", 2, 1.2));
        students.add(new Student("Анна",      "Йцук-3", 3, 3.8));
        students.add(new Student("Мария",     "Йцук-4", 4, 3.1));
        students.add(new Student("Варвара",   "Фыва-5", 5, 4.0));

/*        System.out.println("\n=== Exception checking ===");
        System.out.println("\nConstuctor Student():");
        Object[][] invalidData = {
                {"", "Ячсм-1", 1, 5.0},           // empty name
                {"Иван", "", 1, 5.0},             // empty group
                {"Иван", "Ячсм-1", 0, 5.0},       // course < 1
                {"Иван", "Ячсм-1", 6, 5.0},       // course > 5
                {"Иван", "Ячсм-1", 1, -1.0},      // average score < 0
                {"Иван", "Ячсм-1", 1, 11.0},      // average score > 10
                {null, "Ячсм-1", 1, 5.0},         // null instead name
                {"Иван", null, 1, 5.0},           // null instead group
        };

        for (Object[] data : invalidData) {
            String name = (String) data[0];
            String group = (String) data[1];
            int course = (int) data[2];
            double score = (double) data[3];

            try {
                Student student = new Student(name, group, course, score);
                System.out.println("Error: a student " + name + " was created, although he shouldn't have been!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error caught: " + e.getMessage());
            }
        }

        System.out.println("\nMethod deleteStudents():");
        try {
            Student.deleteStudents(null);
            System.out.println("Error: deleteStudents(null) did not throw an exception!");
        } catch (NullPointerException e) {
            System.out.println("deleteStudents(null): " + e.getMessage());
        }

        ArrayList<Student> emptyList = new ArrayList<>();
        try {
            Student.deleteStudents(emptyList);
            System.out.println("Error: deleteStudents(emptyList) did not throw an exception!");
        } catch (IllegalArgumentException e) {
            System.out.println("deleteStudents(emptyList): " + e.getMessage());
        }

        System.out.println("\n=== All students ===");
        Student.printStudents(students, 1);
        Student.printStudents(students, 2);
        Student.printStudents(students, 3);
        Student.printStudents(students, 4);
        Student.printStudents(students, 5);

        System.out.println("\n=== Delete underachievers ===");

        System.out.println("\n=== Students after deleting ===");
        Student.deleteStudents(students);
        Student.printStudents(students, 1);
        Student.printStudents(students, 2);
        Student.printStudents(students, 3);
        Student.printStudents(students, 4);
        Student.printStudents(students, 5);

        System.out.println("\n=== Transfer to the next course ===");
        Student.goToNextLevel(students);

        System.out.println("\n=== Students after transfer ===");
        Student.printStudents(students, 1);
        Student.printStudents(students, 2);
        Student.printStudents(students, 3);
        Student.printStudents(students, 4);
        Student.printStudents(students, 5);*/


        // task 2
/*        System.out.println("\n=== Telephone Directory ===");

        String[][] phoneData = {
                {"Иванов", "+79991234560"},
                {"Петров", "+79991234561"},
                {"Иванов", "+79991234562"},
                {"Петров", "+79991234563"},
                {"Сидоров", "+79991234564"},
                {"", "+79991234565"},           // empty last name
                {null, "+79991234566"},         // null in name
                {"Смирнов", ""},                // empty phone number
                {"Смирнов", null}               // null in phone
        };

        TelephoneDirectory td = new TelephoneDirectory();

        System.out.println("\n=== Adding entries to the directory ===");
        for (String[] entry : phoneData) {
            String lastName = entry[0];
            String phoneNumber = entry[1];

            try {
                td.add(lastName, phoneNumber);
                System.out.println("Added: " + lastName + " -> " + phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Error adding entry: " + e.getMessage());
            }
        }

        String[] searchLastNames = {"Иванов", "Петров", "Сидоров", "Иванова", "", null};

        System.out.println("\n=== Searching for phone numbers ===");
        for (String lastName : searchLastNames) {
            System.out.println("\nSearch by last name '" + lastName + "':");
            try {
                td.get(lastName);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }*/
    }
}