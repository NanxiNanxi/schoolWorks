/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6_1;

/**
 *
 * @author Administrator
 */
public class SalaryEmployee extends Employee{
    private float monthlySalary;

    public SalaryEmployee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, int projectNo, float monthlySalary) {
        super(firstName, lastName, middleInit, birthDate, employeeNo, departmentNo, projectNo);
        this.monthlySalary = monthlySalary;
    }

    public SalaryEmployee() {
        
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    public float getEarnings(){
        return monthlySalary * 12/52 *2;
    }
   
}
