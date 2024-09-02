package customer;

import account.Account;
import transaction.Transaction;
import transaction.TransactionProcessable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerAccount implements TransactionProcessable {
    private Account account;
    private List<Transaction> transactions;
    private static int numberOfAccounts;

    public CustomerAccount(Account account, Transaction[] transactions) {
        this.account = account;
        this.transactions = new ArrayList<>(List.of(transactions));
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        CustomerAccount.numberOfAccounts = numberOfAccounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void addTransaction(double amount, String description, LocalDate date) {
        Transaction newTransaction = new Transaction(amount, description, date);
        this.transactions.add(newTransaction);
    }

    @Override
    public double getTransactionAmount(LocalDate date) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionDate().equals(date)) {
                return transaction.getAmount();
            }
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "account=" + (account != null ? account.toString() : "null") +
                ", transactions=" + (transactions != null ? transactions.toString() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomerAccount that = (CustomerAccount) object;
        return Objects.equals(account, that.account) && Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, transactions);
    }
}
