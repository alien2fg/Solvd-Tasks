package bank;

import customer.Customer;
import customer.CustomerAccount;

public class Bank {
    private String name;
    private Department[] departments;
    private int departmentCount=0;

    public Bank(String name) {
        this.departments = new Department[1];
        this.name = name;
    }

    public void addDepartment(Department department) {
        if (departmentCount>=departments.length){
            expandDeparmentsArray();
        }
        departments[departmentCount++]=department;
    }

    public void expandDeparmentsArray(){
        int newDepartmentArraySize=departments.length+1;
        Department[] newDepartmentsArray= new Department[newDepartmentArraySize];

        for (int i = 0; i <departments.length; i++) {
            newDepartmentsArray[i]=departments[i];
        }

        departments=newDepartmentsArray;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateTotalBankBalance() {
        double totalBalance = 0.0;

        for (Department department : departments){
            for (Customer customer: department.getCustomers()){
                for(CustomerAccount customerAccount: customer.getAccounts()){
                    totalBalance+= customerAccount.getAccount().getBalance();
                }
            }
        }
        return totalBalance;
    }
}
