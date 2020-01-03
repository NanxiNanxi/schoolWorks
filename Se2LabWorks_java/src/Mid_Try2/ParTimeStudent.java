/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mid_Try2;

/**
 *
 * @author Administrator
 */
public class ParTimeStudent extends Student{
    private int numberOfCourses;
//    private int idTest;
    public ParTimeStudent(){
        this.getCount();
        this.setTestID(this.getCount() + 1000);
    }

    public ParTimeStudent(String firstName, String lastName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate,int numberOfCourses) {
        super(firstName, lastName, middleInit, birthDate, gender, studentNumber, email, registrationDate);
        this.numberOfCourses = numberOfCourses;
        this.getCount();
        this.setTestID(this.getCount() + 1000);
    }
  
    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        if(numberOfCourses > 0){
            this.numberOfCourses = numberOfCourses;
        }
        else this.numberOfCourses = 0;
    }
    public float getTuition(){
        float tuition = 0;
        if(this.getRegistrationDate().getYear() <= 2008){
            tuition =(float)(540 * this.getNumberOfCourses());
        }
        else {
            tuition = (float)(630 * this.getNumberOfCourses());
        }
        return tuition;
    }
       public String record(){
        return this.getLastName() + " " + this.getFirstName() +" " + this.getMiddleInit() +" " + 
               this.getBirthDate().toString() +" " + this.getGender() + " " +this.getStudentNumber() + " "+
               this.getEmail() + " " +this.getRegistrationDate().toString() + " " +
               this.getNumberOfCourses();
    
}
}
