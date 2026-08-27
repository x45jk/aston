package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.6 =====");

        // task 1
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Иванов",   "Йцук-1", 1, 4.5));
        students.add(new Student("Иванова",  "Йцук-1", 1, 2.5));
        students.add(new Student("Петрова",  "Фыва-2", 2, 3.2));
        students.add(new Student("Петров",   "Фыва-2", 2, 1.2));
        students.add(new Student("Сидоров",  "Йцук-3", 3, 3.8));
        students.add(new Student("Кузнецов", "Йцук-4", 4, 3.1));
        students.add(new Student("Васильев", "Фыва-5", 5, 4.0));

        /*System.out.println("=== All students ===");
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
        /*TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", "+79991234560");
        td.add("Петров", "+79991234561");
        td.add("Иванов", "+79991234562");
        td.add("Петров", "+79991234563");
        td.add("Сидоров", "+79991234564");

        System.out.println("\n=== Search by last name 'Иванов' ===");
        td.get("Иванов");

        System.out.println("\n=== Search by last name 'Петров' ===");
        td.get("Петров");

        System.out.println("\n=== Search by last name 'Сидоров' ===");
        td.get("Сидоров");

        System.out.println("\n=== Search by last name 'Иванова' ===");
        td.get("Иванова");*/
    }
}