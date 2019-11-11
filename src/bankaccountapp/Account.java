package bankaccountapp;

// abstract = won't be able to create objects from this class
public abstract class Account implements InterestBaseRate {

    // List common properties
    String name;
    String socialSecurityNumber;
    double balance;

    static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String socialSecurityNumber, double initDeposit) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSocialSecurityNumber = socialSecurityNumber.substring(socialSecurityNumber.length() -2, socialSecurityNumber.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSocialSecurityNumber + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }


    // List common methods
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }


    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }


}
