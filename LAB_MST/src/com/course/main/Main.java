package com.course.main;

import com.course.model.Course;
import com.course.model.Student;
import com.course.service.CourseService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseService service = new CourseService();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Online Course System ---");

        while (true) {
            System.out.println("\n1. Add Course | 2. Enroll | 3. View | 4. Exit");
            System.out.print("Choice: ");
            String opt = sc.nextLine();

            try {
                if (opt.equals("1")) {
                    System.out.print("ID, Name, Seats (comma separated): ");
                    String[] data = sc.nextLine().split(",");
                    service.addCourse(new Course(Integer.parseInt(data[0].trim()), data[1].trim(), Integer.parseInt(data[2].trim())));
                } 
                else if (opt.equals("2")) {
                    System.out.print("Course ID, Student ID, Student Name (comma separated): ");
                    String[] data = sc.nextLine().split(",");
                    service.enrollStudent(Integer.parseInt(data[0].trim()), new Student(Integer.parseInt(data[1].trim()), data[2].trim()));
                } 
                else if (opt.equals("3")) {
                    service.viewAllCourses();
                } 
                else if (opt.equals("4")) {
                    System.out.println("Bye!");
                    break;
                } 
                else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
