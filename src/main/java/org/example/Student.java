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
    // private static final double maxScore     = 10.0;

    Student(String name, String group, int course, double score) {
        this.name     = name;
        this.group    = group;
        this.course   = course;
        this.avgScore = score;
    }

    public static void deleteStudents(ArrayList<Student> al) {
        al.removeIf(n -> n.avgScore < passingScore);
    }

    public static void goToNextLevel(ArrayList<Student> al) {
        Iterator<Student> it = al.iterator();

        while (it.hasNext()) {
            Student student = it.next();

            if (student.avgScore >= passingScore)
                if (student.course < lastCourse) {
                    student.course++;
                    System.out.println(student.name + " was transferred to course " + student.course + ".");
                } else {
                    System.out.println(student.name + " graduated!");
                    it.remove();
                }
        }
    }

    public static void printStudents(ArrayList<Student> al, int course) {
        System.out.println("The following students are studying in course " + course + ":");
        for (Student student : al)
            if (student.course == course)
                System.out.println("- " + student.name);
    }
}
