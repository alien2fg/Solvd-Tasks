package account;

import java.time.LocalDate;
import java.time.Period;

public class LoanAccount extends Account {
    private double loanAmount;
    private double interestRate; // Annual interest rate
    private LocalDate loanStartDate;
    private int loanDurationInMonths; // Duration of the loan

    public LoanAccount(String accountNumber, double balance, LocalDate dateOpened, double loanAmount, double interestRate, int loanDurationInMonths, LocalDate loanStartDate) {
        super(accountNumber, balance, dateOpened);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDurationInMonths = loanDurationInMonths;
        this.loanStartDate = loanStartDate;
    }

    // Calculate the monthly payment based on the loan details
    public double calculateMonthlyPayment() {
        double monthlyRate = interestRate / 100 / 12;
        int numberOfPayments = loanDurationInMonths;
        return loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    // Apply a payment towards the loan balance
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
        // Subtract the payment from the loan amount
        loanAmount -= amount;
        // Ensure loan amount does not go negative
        if (loanAmount < 0) {
            loanAmount = 0;
        }
        super.deposit(amount); // Record the payment in the account balance
    }

    // Getters and setters for loan details
    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        if (loanAmount < 0) {
            throw new IllegalArgumentException("Loan amount cannot be negative.");
        }
        this.loanAmount = loanAmount;
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

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public int getLoanDurationInMonths() {
        return loanDurationInMonths;
    }

    public void setLoanDurationInMonths(int loanDurationInMonths) {
        if (loanDurationInMonths <= 0) {
            throw new IllegalArgumentException("Loan duration must be positive.");
        }
        this.loanDurationInMonths = loanDurationInMonths;
    }

    @Override
    public String toString() {
        return super.toString() + " | Loan Amount: " + loanAmount + " | Interest Rate: " + interestRate + "% | Duration: " + loanDurationInMonths + " months";
    }
}