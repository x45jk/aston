package org.example;
import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    private String name;
    private String group;
    private int    course;
    private double avgScore;
    // const
    private static final int    lastCourse   = 5;
    private static final int    passingScore = 3;
    private static final double maxScore     = 10.0;

    Student(String name, String group, int course, double avgScore) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty or null.");
        }
        if (group == null || group.trim().isEmpty()) {
            throw new IllegalArgumentException("The group cannot be empty or null.");
        }
        if (course < 1 || course > lastCourse) {
            throw new IllegalArgumentException("The course must be from 1 to " + lastCourse + " (received: " + course + ")");
        }
        if (avgScore < 0 || avgScore > maxScore) {
            throw new IllegalArgumentException("The average score must be from 0 to " + maxScore + " (received: " + avgScore + ")");
        }

        this.name     = name;
        this.group    = group;
        this.course   = course;
        this.avgScore = avgScore;
    }

    // не додумался как реализовать 'deleteStudents()' и 'printStudents()' с параметрами типа Student
    public static void deleteStudents(ArrayList<Student> students) {
        if (students == null) {
            throw new NullPointerException("The list of students cannot be 'null'.");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("The student list is empty.");
        }

        students.removeIf(n -> n.avgScore < passingScore);
    }

    public static void goToNextLevel(ArrayList<Student> students) {
        if (students == null) {
            throw new NullPointerException("The list of students cannot be 'null'.");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("The student list is empty.");
        }

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student student = it.next();

            if (student.avgScore >= passingScore) {
                if (student.course < lastCourse) {
                    student.course++;
                    System.out.println(student.name + " was transferred to course " + student.course + ".");
                } else {
                    System.out.println(student.name + " graduated!");
                    it.remove();
                }
            }
        }
    }

    public static void printStudents(ArrayList<Student> students, int course) {
        if (students == null) {
            throw new NullPointerException("The list of students cannot be 'null'.");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("The student list is empty.");
        }
        if (course < 1 || course > lastCourse) {
            throw new IllegalArgumentException("The course must be from 1 to " + lastCourse + " (received: " + course + ")");
        }

        System.out.println("The following students are studying in course " + course + ":");
        for (Student student : students) {
            if (student.course == course) {
                System.out.println("- " + student.name);
            }
        }
    }
}
