package account;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, LocalDate dateOpened, double overdraftLimit) {
        super(accountNumber, balance, dateOpened);
        this.overdraftLimit = overdraftLimit;
    }

    // Getter and setter for overdraftLimit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    // Overriding withdraw to consider overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        double newBalance = getBalance() - amount;
        if (newBalance < -overdraftLimit) {
            throw new IllegalArgumentException("Insufficient funds and overdraft limit exceeded.");
        }
        super.withdraw(amount); // Proceed with withdrawal if within overdraft limit
    }

    @Override
    public String toString() {
        return super.toString() + " | Overdraft Limit: " + overdraftLimit;
    }
}