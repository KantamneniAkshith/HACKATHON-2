import java.util.Scanner;

class Student {

    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Constructor
    Student(String name, int roll, double mark, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        marks = mark;
        courseName = course;
        courseCredits = credits;
    }

    // Calculate course fee
    double calculateFee() {
        double fee = courseCredits * 1500;
        return fee;
    }

    // Check eligibility
    boolean checkEligibility() {
        if (marks >= 50)
            return true;
        else
            return false;
    }

    // Calculate scholarship
    double calculateScholarship() {
        double scholarship;

        if (marks >= 85)
            scholarship = calculateFee() * 0.20;
        else if (marks >= 70)
            scholarship = calculateFee() * 0.10;
        else
            scholarship = 0;

        return scholarship;
    }

    // Calculate final fee
    double calculateFinalFee() {
        double finalFee = calculateFee() - calculateScholarship();
        return finalFee;
    }

    // Display details
    void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public class StudentRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        Student student = new Student(name, roll, marks, course, credits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed");
            System.out.println("Student is not eligible.");
        }

        sc.close();
    }
}