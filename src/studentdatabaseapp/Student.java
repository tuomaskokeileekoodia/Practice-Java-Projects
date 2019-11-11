package studentdatabaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private final int costOfCourse = 600;
    private static int id = 1000;

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level:  ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {

        System.out.println("\n----- enroll() method: -----");

        do {
            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equalsIgnoreCase("q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {
                break;
            }
            } while (true);
    }

    // View balance
    public void viewBalance() {
        System.out.println("\n----- viewBalance() method: -----");
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance  = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

}
