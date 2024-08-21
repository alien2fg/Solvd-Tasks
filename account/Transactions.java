package account;

import java.time.LocalDate;

public class Transactions {
    private LocalDate transactionDate;
    private double amount;
    private String description;

    public Transactions(double amount, String description, LocalDate transactionDate) {
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", description='" + description + '\'' +
                '}';
    }
}
