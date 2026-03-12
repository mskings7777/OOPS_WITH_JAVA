package com.course.service;

import com.course.model.*;
import com.course.exception.*;
import java.io.*;
import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public CourseService() { loadData(); }

    public void addCourse(Course c) {
        if (getCourse(c.id) == null) {
            courses.add(c);
            saveData();
            System.out.println("Course added.");
        } else {
            System.out.println("Course ID already exists.");
        }
    }

    public void enrollStudent(int courseId, Student s) throws Exception {
        Course c = getCourse(courseId);
        
        if (c == null) throw new CourseNotFoundException("Course not found!");
        if (c.enrolledStudents.size() >= c.maxSeats) throw new CourseFullException("Course is full!");
        
        for (Student curr : c.enrolledStudents) {
            if (curr.id == s.id) throw new DuplicateEnrollmentException("Already enrolled!");
        }
        
        c.enrolledStudents.add(s);
        saveData();
        System.out.println("Enrolled successfully.");
    }

    private Course getCourse(int id) {
        for (Course c : courses) if (c.id == id) return c;
        return null;
    }

    public void viewAllCourses() {
        for (Course c : courses) c.display();
    }

    private void saveData() {
        try (PrintWriter out = new PrintWriter("courses.txt")) {
            for (Course c : courses) {
                out.println("C," + c.id + "," + c.name + "," + c.maxSeats);
                for (Student s : c.enrolledStudents) out.println("S," + s.id + "," + s.name);
            }
        } catch (Exception e) { }
    }

    private void loadData() {
        try (BufferedReader in = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            Course c = null;
            while ((line = in.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals("C")) {
                    c = new Course(Integer.parseInt(d[1]), d[2], Integer.parseInt(d[3]));
                    courses.add(c);
                } else if (d[0].equals("S") && c != null) {
                    c.enrolledStudents.add(new Student(Integer.parseInt(d[1]), d[2]));
                }
            }
        } catch (Exception e) { }
    }
}
