package account;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    private double interestRate;
    private LocalDate lastInterestAppliedDate;

    public SavingsAccount(String accountNumber, double balance, LocalDate dateOpened, double interestRate) {
        super(accountNumber, balance, dateOpened);
        this.interestRate = interestRate;
        this.lastInterestAppliedDate = dateOpened;
    }


    public void applyInterest() {
        LocalDate now = LocalDate.now();
        if (now.isAfter(lastInterestAppliedDate.plusYears(1))) {
            double interest = getBalance() * (interestRate / 100);
            deposit(interest);
            lastInterestAppliedDate = now;
        }
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() + " | Interest Rate: " + interestRate + "%";
    }
}