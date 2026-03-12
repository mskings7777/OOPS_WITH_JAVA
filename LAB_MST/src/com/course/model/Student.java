package com.course.model;

public class Student {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("   -> Student ID: " + id + ", Name: " + name);
    }
}
