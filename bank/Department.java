package bank;

import customer.Customer;

import java.util.Arrays;
import java.util.Objects;

public class Department {
    private String name;
    private String departmentlocation;
    private Customer[] customers;
    private int customerCount;

    public Department(String departmentlocation, String name) {
        this.departmentlocation=departmentlocation;
        this.customers = new Customer[1];
        this.name = name;
    }


    public void addCustomer(Customer customer) {
        if (customerCount >= customers.length) {
            expandCustomerArray();
        }
        customers[customerCount++] = customer;
    }

    public void expandCustomerArray(){
        int newCustomerArraySize=customers.length+1;
        Customer[] newCustomers = new Customer[newCustomerArraySize];

        System.arraycopy(customers, 0, newCustomers, 0, customers.length);

        customers=newCustomers;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public String getDepartmentlocation() {
        return departmentlocation;
    }

    public void setDepartmentlocation(String departmentlocation) {
        this.departmentlocation = departmentlocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "customerCount=" + customerCount +
                ", name='" + name + '\'' +
                ", departmentlocation='" + departmentlocation + '\'' +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Department that = (Department) object;
        return customerCount == that.customerCount && Objects.equals(name, that.name) && Objects.equals(departmentlocation, that.departmentlocation) && Objects.deepEquals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departmentlocation, Arrays.hashCode(customers), customerCount);
    }
}
