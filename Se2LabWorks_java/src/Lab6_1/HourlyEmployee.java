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
public class HourlyEmployee extends Employee{
    private float hourlyRate;
    private float hoursWorked;

    public HourlyEmployee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, int projectNo, float hourlyRate, float hourswored) {
        super(firstName, lastName, middleInit, birthDate, employeeNo, departmentNo, projectNo);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hourswored;
    }

    public HourlyEmployee() {
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public float getHourswored() {
        return hoursWorked;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHourswored(float hourswored) {
        this.hoursWorked = hourswored;
    }
    
    public float getEarnings(){
        float earnings = 0;
        if(hoursWorked > 80){
            earnings =(float)(hourlyRate * 80 + (hoursWorked-80)*hourlyRate*1.5);
        }
        else{ 
            earnings = (float)hourlyRate*hoursWorked;}
        return earnings;
    }
    
}
