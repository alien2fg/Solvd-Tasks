package bank;

import customer.Customer;

public class Department {
    private String name;
    private String departmentlocation;
    private Customer[] customers;
    private int customerCount = 0;

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

        for (int i = 0; i < customers.length; i++) {
            newCustomers[i]=customers[i];
        }

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
}
