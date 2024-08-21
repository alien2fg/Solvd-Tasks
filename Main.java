import account.*;
import bank.Bank;
import bank.Department;
import customer.Customer;
import customer.CustomerAccount;
import customer.CustomerAddress;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("My Bank");

        // Create departments
        Department department1 = new Department("New York", "Downtown Branch");
        Department department2 = new Department("San Francisco", "Main Branch");

        // Add departments to the bank
        bank.addDepartment(department1);
        bank.addDepartment(department2);

        // Create customers
        CustomerAddress address1 = new CustomerAddress("123 Main St", "New York");
        Customer customer1 = new Customer(address1, LocalDate.of(1980, 5, 15), "John", "Doe");

        CustomerAddress address2 = new CustomerAddress("456 Elm St", "San Francisco");
        Customer customer2 = new Customer(address2, LocalDate.of(1990, 8, 25), "Jane", "Smith");

        // Create accounts
        Account savingsAccount1 = new SavingsAccount("SA001", 1500.0, LocalDate.of(2022, 1, 1), 0.02);
        Account currentAccount1 = new CurrentAccount("CA001", 500.0, LocalDate.of(2022, 1, 1), 100.0);

        Account savingsAccount2 = new SavingsAccount("SA002", 2500.0, LocalDate.of(2021, 6, 15), 0.03);
        Account loanAccount1 = new LoanAccount("LA001", 1000.0, LocalDate.of(2021, 6, 15), 0.05, 5000.0, 12, LocalDate.of(2021, 6, 15));

        // Create transactions
        Transactions depositTransaction = new Transactions(500.0, "Deposit to savings", LocalDate.now());
        Transactions withdrawalTransaction = new Transactions(100.0, "Withdrawal from current", LocalDate.now());

        // Create customer accounts
        CustomerAccount customerAccount1 = new CustomerAccount(savingsAccount1, customer1, new Transactions[]{depositTransaction});
        CustomerAccount customerAccount2 = new CustomerAccount(currentAccount1, customer1, new Transactions[]{withdrawalTransaction});

        CustomerAccount customerAccount3 = new CustomerAccount(savingsAccount2, customer2, new Transactions[]{depositTransaction});
        CustomerAccount customerAccount4 = new CustomerAccount(loanAccount1, customer2, new Transactions[]{withdrawalTransaction});

        // Add customer accounts to customers
        customer1.addCustomerAccount(customerAccount1);
        customer1.addCustomerAccount(customerAccount2);

        customer2.addCustomerAccount(customerAccount3);
        customer2.addCustomerAccount(customerAccount4);

        // Add customers to departments
        department1.addCustomer(customer1);
        department2.addCustomer(customer2);

        // Calculate and print total balance in the bank
        double totalBalance = bank.calculateTotalBankBalance();
        System.out.println("Total balance in the bank: " + totalBalance);
    }
}