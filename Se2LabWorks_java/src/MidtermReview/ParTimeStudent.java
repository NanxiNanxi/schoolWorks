/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MidtermReview;

/**
 *
 * @author Administrator
 */
public class ParTimeStudent extends Student{
    private int numberOfCourse;
    public ParTimeStudent(){}

    public ParTimeStudent(String firstName, String lastName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate, int numberOfCourse) {
        super(firstName, lastName, middleInit, birthDate, gender, studentNumber, email, registrationDate);
        this.numberOfCourse = numberOfCourse;
    }

    public int getNumberOfCourse() {
        return numberOfCourse;
    }

    public void setNumberOfCourse(int numberOfCourse) {
        if(numberOfCourse < 0) 
        {
            numberOfCourse =0;
        }
        else 
        {
            this.numberOfCourse = numberOfCourse;
        }
    }
    public float getTuition(){
        if(this.getRegistrationDate().getYear() <= 2008)
        {
            return (float)(numberOfCourse * 540);
            
        }
        else return (float)(numberOfCourse * 630);
    }
     public String record(){
        return this.getLastName() + " " + this.getFirstName() +" " + this.getMiddleInit() +" " + 
               this.getBirthDate().toString() +" " + this.getGender() + " " +this.getStudentNumber() + " "+
               this.getEmail() + " " +this.getRegistrationDate().toString() + " " +
               this.getNumberOfCourse();
    }
}
