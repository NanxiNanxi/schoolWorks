/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5_3;

import Lab5_2.*;
import Lab4.*;

/**
 *
 * @author Administrator
 */
public class Employee extends Person{
    int employeeNo;
    private float monthlySalary;
    private Date hireDate;

    public Employee() {
    }

    public Employee(String firstName, String lastName, char middleInit, Date birthDate,int employeeNo, float monthlySalary, Date hireDate) {
        super(firstName, lastName, middleInit, birthDate);
        this.employeeNo = employeeNo;
        this.monthlySalary = monthlySalary;
        this.hireDate = hireDate;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public String toString()
    {
        return employeeNo +": "+ lastName + " " + firstName + " " + middleInit + "\nBirthday: " + birthDate.toString()
                + "\nMonthly salary: " + monthlySalary + "\nHire date: " + hireDate;
    }
    
    public String writeAsRecord()
    {
       return firstName + " " + lastName + " " + middleInit + " " + birthDate.toString()
                + " " + monthlySalary + " " + hireDate;
    }
}
