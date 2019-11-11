package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    private String dot = ".";



    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for department - return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email

        // Ratkaisematta edelleen, kuinka tulostaa sähköposti oikein, jos työntekijä valitsee "ei osastoa"
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//        System.out.println("Your email is: " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". \nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "sales"; }
        else if (departmentChoice == 2) { return "development"; }
        else if (departmentChoice == 3) { return "accounting"; }
        else { return "";}
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#¤%&";
        char[] password = new char[length];
        for (int i = 0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
//            System.out.println(rand);
//            System.out.println("Yllä olevan numeron mukaan salasanasi seuraava merkki on: " + passwordSet.charAt(rand));

        }
        return new String(password);
    }


    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;

    }

    // Define an alternative email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}
