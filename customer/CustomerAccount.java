package customer;

import account.Account;
import account.CurrentAccount;
import account.LoanAccount;
import account.SavingsAccount;
import transaction.Transaction;
import transaction.TransactionProcessable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerAccount implements TransactionProcessable {
    private LoanAccount loanAccount;
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;
    private List<Transaction> transactions;
    private static int numberOfAccounts;


    public CustomerAccount(Account account, Transaction[] transactions) {
        this.transactions = new ArrayList<>(List.of(transactions));
        numberOfAccounts++;

        if (account instanceof LoanAccount) {
            this.loanAccount = (LoanAccount) account;
        } else if (account instanceof SavingsAccount) {
            this.savingsAccount = (SavingsAccount) account;
        } else if (account instanceof CurrentAccount) {
            this.currentAccount = (CurrentAccount) account;
        }
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
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


        if (currentAccount != null) {
            if (amount >= 0) {
                currentAccount.deposit(amount, description);
            } else {
                currentAccount.withdraw(-amount, description);
            }
        }
        if (savingsAccount != null) {
            if (amount >= 0) {
                savingsAccount.deposit(amount, description);
            } else {
                savingsAccount.withdraw(-amount, description);
            }
        }
        if (loanAccount != null) {
            if (amount >= 0) {
                loanAccount.deposit(amount, description);
            } else {

                System.out.println("Withdrawals are not supported for loan accounts.");
            }
        }
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
                "loanAccount=" + (loanAccount != null ? loanAccount.toString() : "null") +
                ", savingsAccount=" + (savingsAccount != null ? savingsAccount.toString() : "null") +
                ", currentAccount=" + (currentAccount != null ? currentAccount.toString() : "null") +
                ", transactions=" + (transactions != null ? transactions.toString() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomerAccount that = (CustomerAccount) object;
        return Objects.equals(loanAccount, that.loanAccount) &&
                Objects.equals(savingsAccount, that.savingsAccount) &&
                Objects.equals(currentAccount, that.currentAccount) &&
                Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAccount, savingsAccount, currentAccount, transactions);
    }
}
