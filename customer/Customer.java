package customer;

import java.time.LocalDate;
import java.util.Arrays;

public class Customer {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private CustomerAddress customerAddress;
    private CustomerAccount[] accounts;
    private int customerAccountsSize=0;

    public Customer(CustomerAddress customerAddress, LocalDate dateOfBirth, String firstName, String lastName) {
        this.customerAddress = customerAddress;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new CustomerAccount[1];
    }

    public void addCustomerAccount(CustomerAccount customerAccount) {
        if (customerAccountsSize >= accounts.length) {
            expandCustomerAccount();
        }
        accounts[customerAccountsSize++] = customerAccount;
    }

    public void expandCustomerAccount(){
        int newcustomerAccountsSize=accounts.length+1;
        CustomerAccount[] newCustomerAccount = new CustomerAccount[newcustomerAccountsSize];

        for (int i = 0; i < accounts.length; i++) {
            newCustomerAccount[i]=accounts[i];
        }

        accounts=newCustomerAccount;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public CustomerAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(CustomerAccount[] accounts) {
        this.accounts = accounts;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accounts=" + Arrays.toString(accounts) +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", customerAddress=" + customerAddress +
                ", customerAccountsSize=" + customerAccountsSize +
                '}';
    }
}
