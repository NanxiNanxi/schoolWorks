/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author zhou6718
 */
public abstract class Employee extends Person{
   private int employeeNo;
   private int departmentNo;
   private int projectNo;
   
 public Employee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, int projectNo) {
        super(firstName, lastName, middleInit, birthDate);
        this.employeeNo = employeeNo;
        this.departmentNo = departmentNo;
        this.projectNo = projectNo;
    }
  public Employee() {
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }
   public String toString()
   {
       return employeeNo + ": " + lastName + ", " + firstName + " " + middleInit + "--- "+ getEarnings();
   }
    public abstract float getEarnings();
}
