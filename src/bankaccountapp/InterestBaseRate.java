package bankaccountapp;

public interface InterestBaseRate {

    // Write a method that returns the base rate
    default double getBaseRate() {
        return 2.5;
    }

}

