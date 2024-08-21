package account;

import java.time.LocalDate;

public class Account {
    private String accountNumber;
    private LocalDate dateOpened;
    private double balance;

    public Account(String accountNumber, double balance, LocalDate dateOpened) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = dateOpened;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public void deposit(double amount, String description) {
        balance += amount;
        System.out.println(description);
    }

    public void withdraw(double amount){
        if (amount<=balance){
            balance-=amount;
        }else{
            System.out.println("Insufficient funds");
        }
    }

    public void withdraw(double amount, String reason) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Reason for withdrawal: " + reason);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", dateOpened=" + dateOpened +
                ", balance=" + balance +
                '}';
    }
}
