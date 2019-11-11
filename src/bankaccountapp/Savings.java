package bankaccountapp;

public class Savings extends Account{
    // List properties specific to the Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    // COnstructor to initialize settings for the Savings properties
    public Savings(String name, String socialSecurityNumber, double initDeposit) {
        super(name, socialSecurityNumber, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }



    // List any methods specific to savings account
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your SAVINGS Account Features" +
                "\n Safety Deposit Box ID : " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }

}
