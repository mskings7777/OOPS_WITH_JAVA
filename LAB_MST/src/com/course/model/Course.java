package com.course.model;

import java.util.ArrayList;

public class Course {
    public int id;
    public String name;
    public int maxSeats;
    public ArrayList<Student> enrolledStudents;

    public Course(int id, String name, int maxSeats) {
        this.id = id;
        this.name = name;
        this.maxSeats = maxSeats;
        this.enrolledStudents = new ArrayList<>();
    }

    public void display() {
        System.out.println("\nCourse ID: " + id + " | Name: " + name);
        System.out.println("Seats: " + enrolledStudents.size() + "/" + maxSeats);
        
        if (enrolledStudents.isEmpty()) {
            System.out.println("   (No students enrolled yet)");
        } else {
            System.out.println("   Enrolled Students:");
            for (Student s : enrolledStudents) {
                s.display();
            }
        }
    }
}
