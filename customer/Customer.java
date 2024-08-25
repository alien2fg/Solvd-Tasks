package customer;

import java.util.Arrays;
import java.util.Objects;

public class Customer implements CustomerInfoProvider{
    private CustomerData customerData;
    private CustomerAccount[] accounts;
    private int customerAccountsSize;

    public Customer(CustomerData customerData) {
        this.accounts = new CustomerAccount[1];
        this.customerAccountsSize = customerAccountsSize;
        this.customerData = customerData;
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

        System.arraycopy(accounts, 0, newCustomerAccount, 0, accounts.length);

        accounts=newCustomerAccount;
    }

    public void printCustomerDetails() {
        System.out.println("Customer Details:");
        System.out.println(this);
    }

    public String getFullName() {
        return customerData.getFirstName() + " " + customerData.getLastName();
    }

    public CustomerAddress getCustomerAddress() {
        return customerData.getCustomerAddress();
    }

    public CustomerAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(CustomerAccount[] accounts) {
        this.accounts = accounts;
    }

    public int getCustomerAccountsSize() {
        return customerAccountsSize;
    }

    public void setCustomerAccountsSize(int customerAccountsSize) {
        this.customerAccountsSize = customerAccountsSize;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{")
                .append("fullName='").append(getFullName()).append('\'')
                .append(", dateOfBirth=").append(customerData.getDateOfBirth())
                .append(", address=").append(customerData.getCustomerAddress())
                .append(", numberOfAccounts=").append(customerAccountsSize)
                .append(", accounts=[");

        if (accounts != null && customerAccountsSize > 0) {
            for (int i = 0; i < customerAccountsSize; i++) {
                if (i > 0) sb.append(", ");
                sb.append("Account ").append(i + 1).append(": ").append(accounts[i].toString());
            }
        } else {
            sb.append("No accounts");
        }

        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return customerAccountsSize == customer.customerAccountsSize && Objects.equals(customerData, customer.customerData) && Objects.deepEquals(accounts, customer.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerData, Arrays.hashCode(accounts), customerAccountsSize);
    }
}
