import java.util.Scanner;
import java.util.InputMismatchException;



class StudentInput {

    private Scanner scanner = new Scanner(System.in);

    public String getStudentName() {
        System.out.print("Enter Student Name: ");
        return scanner.nextLine();
    }

    public int getStudentMarks() {
        System.out.print("Enter Marks (0 - 100): ");
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}


class GradeEvaluator {

    public static String calculateGrade(int marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "Fail";
        }
    }
}

public class gradeAnalysis {

    public static void main(String[] args) {

        StudentInput input = new StudentInput();

        try {
            String name = input.getStudentName();
            int marks = input.getStudentMarks();

            String grade = GradeEvaluator.calculateGrade(marks);

            System.out.println("\n----- Student Result -----");
            System.out.println("Student Name   : " + name);
            System.out.println("Marks Entered  : " + marks);
            System.out.println("Grade Obtained : " + grade);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric marks only.");

        } finally {
            input.closeScanner();
            System.out.println("\nMarks evaluation completed.");
        }
    }
}
