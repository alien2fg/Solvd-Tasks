import account.*;
import bank.Bank;
import bank.Department;
import customer.Customer;
import customer.CustomerAccount;
import customer.CustomerAddress;
import customer.CustomerData;
import utils.FinancialUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("My Bank");
    private static Customer[] customers = new Customer[1];
    private static int customerCount = 0;

    public static void main(String[] args) {

        // Bank and Department Information
        System.out.println("Welcome to the Bank Management System");
        System.out.println("Enter department location:");
        String departmentlocation = scanner.nextLine();
        System.out.println("Enter department name:");
        String departmentName = scanner.nextLine();
        Department department = new Department(departmentlocation,departmentName);
        System.out.println("Bank: " + bank.getName());
        System.out.println("Department: " + department.getName());
        bank.addDepartment(department);

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCustomer(department);
                    break;
                case 2:
                    addAccount(department);
                    break;
                case 3:
                    displayCustomers(department);
                    break;
                case 4:
                    printTotalBalance();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private static void displayMenu(){
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Account");
        System.out.println("3. Display Customers");
        System.out.println("4. Display total balance in the bank");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCustomer(Department department) {
        System.out.println("Enter customer first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter customer last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter customer date of birth (YYYY-MM-DD):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter customer address:");
        System.out.println("Street:");
        String street = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        CustomerAddress address = new CustomerAddress(street, city);

        // Resize the customer array if necessary
        if (customerCount >= customers.length) {
            Customer[] newCustomers = new Customer[customers.length + 1];
            System.arraycopy(customers, 0, newCustomers, 0, customers.length);
            customers = newCustomers;
        }

        // Create and add the new customer
        CustomerData customerData = new CustomerData(address, dateOfBirth,firstName,lastName);
        Customer customer = new Customer(customerData);
        customers[customerCount++] = customer;
        department.addCustomer(customer); // Add the customer to the department

        System.out.println("Customer added successfully.");
    }

    private static void addAccount(Department department) {
        System.out.println("Select customer by index (0 to " + (department.getCustomers().length - 1) + "):");
        for (int i = 0; i < department.getCustomers().length; i++) {
            System.out.println(i + ": " + department.getCustomers()[i].getFullName());
        }

        int customerIndex = Integer.parseInt(scanner.nextLine());
        if (customerIndex < 0 || customerIndex >= department.getCustomers().length) {
            System.out.println("Invalid customer index.");
            return;
        }

        Customer customer = department.getCustomers()[customerIndex];

        System.out.println("Choose account type (1: Savings, 2: Loan, 3: Current):");
        int accountType = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double balance = Double.parseDouble(scanner.nextLine());

        Account account = null;
        switch (accountType) {
            case 1: // Savings Account
                System.out.println("Enter interest rate (as a percentage):");
                double interestRate = Double.parseDouble(scanner.nextLine());
                account = new SavingsAccount(accountNumber, balance, LocalDate.now(), interestRate);

                // Demonstrate FinancialUtils methods
                double futureValue = ((SavingsAccount) account).getFutureValue(5); // Example for 5 years
                System.out.println("Predicted future value after 5 years: " + FinancialUtils.roundToTwoDecimalPlaces(futureValue));
                break;
            case 2: // Loan Account
                System.out.println("Enter loan amount:");
                double loanAmount = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter interest rate (as a percentage):");
                double loanInterestRate = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter loan duration in months:");
                int duration = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter loan start date (YYYY-MM-DD):");
                LocalDate loanStartDate = LocalDate.parse(scanner.nextLine());
                account = new LoanAccount(accountNumber, balance, LocalDate.now(), loanAmount, loanInterestRate, duration, loanStartDate);

                // Demonstrate FinancialUtils methods
                double monthlyPayment = ((LoanAccount) account).getMonthlyPayment();
                double totalCost = ((LoanAccount) account).getTotalLoanCost();
                System.out.println("Calculated monthly payment for loan account: " + FinancialUtils.roundToTwoDecimalPlaces(monthlyPayment));
                System.out.println("Total cost of the loan: " + FinancialUtils.roundToTwoDecimalPlaces(totalCost));
                break;
            case 3: // Current Account
                System.out.println("Enter overdraft limit:");
                double overdraftLimit = Double.parseDouble(scanner.nextLine());
                account = new CurrentAccount(accountNumber, balance, LocalDate.now(), overdraftLimit);

                // CurrentAccount specific calculations can be added here if needed
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }

        System.out.println("Enter transaction description:");
        String description = scanner.nextLine();
        System.out.println("Enter transaction amount:");
        double transactionAmount = Double.parseDouble(scanner.nextLine());
        Transactions transaction = new Transactions(transactionAmount, description, LocalDate.now());

        CustomerAccount customerAccount = new CustomerAccount(account, customer, new Transactions[]{transaction});
        customer.addCustomerAccount(customerAccount);

        System.out.println("Account added successfully.");
    }

    private static void displayCustomers(Department department) {
        System.out.println("Customer Summary:");
        for (Customer customer : department.getCustomers()) {
            if (customer != null) {
                System.out.println(customer);
            }
        }
    }

    private static void printTotalBalance(){
        double totalBalance = bank.calculateTotalBankBalance();
        System.out.println("Total balance in the bank: " + totalBalance);
    }

}


