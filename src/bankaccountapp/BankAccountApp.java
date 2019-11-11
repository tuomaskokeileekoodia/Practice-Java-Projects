package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read a CSV file
        String bankAccountFile = "C:\\Academy\\Oheistiedostot\\NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(bankAccountFile);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String socialSecurityNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble( accountHolder[3]);
//            System.out.println(name + " " + socialSecurityNumber + " " + accountType +" " + "$" + initDeposit);
            if (accountType.equals("Savings")) {
//                System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name, socialSecurityNumber, initDeposit));
            }
            else if (accountType.equals("Checking")) {
//                System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name, socialSecurityNumber, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        accounts.get(5).showInfo();

        for (Account acc : accounts) {
            System.out.println("\n*********");
            acc.showInfo();
        }

        accounts.get((int) Math.random() * accounts.size()).deposit(10000);
        accounts.get((int) Math.random() * accounts.size()).deposit(1500);

    }
}
