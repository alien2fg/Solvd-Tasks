package customer;

import account.Account;
import account.Transactions;

import java.util.Arrays;

public class CustomerAccount {
    private Customer customer;
    private Account account;
    private Transactions[] transactions;
    private static int numberOfAccounts =0;

    public CustomerAccount(Account account, Customer customer, Transactions[] transactions) {
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

    public Transactions[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "account=" + account +
                ", customer=" + customer +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
