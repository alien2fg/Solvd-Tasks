package bank;

import customer.Customer;
import customer.CustomerAccount;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bank {
    private static final String DEFAULT_NAME;
    private String name;
    private Set<Department> departments; //avoid duplication of departments


    static {
        DEFAULT_NAME = "My Bank";
        System.out.println("Static block in Bank class executed. Default bank name set to: " + DEFAULT_NAME);
    }

    public Bank() {
        this(DEFAULT_NAME);
    }

    public Bank(String name) {
        this.departments = new HashSet<>();
        this.name = name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public double calculateTotalBankBalance() {
        double totalBalance = 0.0;

        for (Department department : departments) {
            for (Customer customer : department.getCustomers()) {
                for (CustomerAccount customerAccount : customer.getAccounts()) {
                    // Check each type of account and add its balance to the total
                    if (customerAccount.getCurrentAccount() != null) {
                        totalBalance += customerAccount.getCurrentAccount().getBalance();
                    }
                    if (customerAccount.getSavingsAccount() != null) {
                        totalBalance += customerAccount.getSavingsAccount().getBalance();
                    }
                    if (customerAccount.getLoanAccount() != null) {
                        // Assuming you want to account for loan balances, but remember:
                        // Loan accounts may have negative balances or outstanding loan amounts.
                        // You might want to handle it differently, e.g., adding positive balances only.
                        totalBalance += customerAccount.getLoanAccount().getBalance(); // Check this logic based on your needs.
                    }
                }
            }
        }
        return totalBalance;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bank bank = (Bank) object;
        return Objects.equals(name, bank.name) && Objects.equals(departments, bank.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departments);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "departments=" + departments +
                ", name='" + name + '\'' +
                '}';
    }
}
