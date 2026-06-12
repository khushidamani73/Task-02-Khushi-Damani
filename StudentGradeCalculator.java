import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("=================================");
        System.out.println("     STUDENT GRADE CALCULATOR    ");
        System.out.println("=================================");

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        // validate subjects
        while (subjects <= 0) {
            System.out.print("Invalid! Enter valid number of subjects: ");
            subjects = sc.nextInt();
        }

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            System.out.print("Enter marks for Subject " + i + " (0-100): ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.print("Invalid! Enter marks again (0-100): ");
                marks = sc.nextInt();
            }

            totalMarks += marks;
        }

        // Correct percentage calculation
        double percentage = (double) totalMarks / (subjects * 100) * 100;

        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        String status = (percentage >= 50) ? "PASS" : "FAIL";

        double average = (double) totalMarks / subjects;

        System.out.println("\n=================================");
        System.out.println("          RESULT CARD            ");
        System.out.println("=================================");
        System.out.println("Student Name : " + studentName);
        System.out.println("Total Marks  : " + totalMarks + "/" + (subjects * 100));
        System.out.println("Average      : " + String.format("%.2f", average));
        System.out.println("Percentage   : " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade        : " + grade);
        System.out.println("Status       : " + status);
        System.out.println("=================================");

        sc.close();
    }
}