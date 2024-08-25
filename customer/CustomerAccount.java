package customer;

import account.Account;
import transaction.Transaction;
import transaction.TransactionProcessable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class CustomerAccount implements TransactionProcessable {
    private Customer customer;
    private Account account;
    private Transaction[] transactions;
    private static int numberOfAccounts;

    public CustomerAccount(Account account, Customer customer, Transaction[] transactions) {
        this.account = account;
        this.customer = customer;
        this.transactions = transactions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        CustomerAccount.numberOfAccounts = numberOfAccounts;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public void addTransaction(double amount, String description, LocalDate date) {
        Transaction newTransaction = new Transaction(amount, description, date);
        Transaction[] newTransactions = new Transaction[transactions.length + 1];
        System.arraycopy(transactions, 0, newTransactions, 0, transactions.length);
        newTransactions[newTransactions.length - 1] = newTransaction;
        this.transactions = newTransactions;
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
                ", transactions=" + (transactions != null ? Arrays.toString(transactions) : "null") +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomerAccount that = (CustomerAccount) object;
        return Objects.equals(customer, that.customer) && Objects.equals(account, that.account) && Objects.deepEquals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, account, Arrays.hashCode(transactions));
    }
}
