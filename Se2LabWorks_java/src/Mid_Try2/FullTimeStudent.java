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
public class FullTimeStudent extends Student{
    private boolean insuranceOptOut;
    private boolean studentCentreOptOut;
    private static int FTcount;
    private int idTest;

    public FullTimeStudent() {
       this.getCount();
       this.setTestID(this.getCount() + 1000);
    }

    public FullTimeStudent(String firstName, String lastName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate, boolean insuranceOptOut, boolean studentCentreOptOut) {
        super(firstName, lastName, middleInit, birthDate, gender, studentNumber, email, registrationDate);
        this.insuranceOptOut = insuranceOptOut;
        this.studentCentreOptOut = studentCentreOptOut;
        this.getCount();
        this.setTestID(this.getCount() + 1000);
    }
    public int getIDTest(){
        return FTcount+1000;
    }
    public static int getFTcount(){
        return FTcount;
    }
    public boolean isInsuranceOptOut() {
        return insuranceOptOut;
    }

    public void setInsuranceOptOut(boolean insuranceOptOut) {
        this.insuranceOptOut = insuranceOptOut;
    }

    public boolean isStudentCentreOptOut() {
        return studentCentreOptOut;
    }

    public void setStudentCentreOptOut(boolean studentCentreOptOut) {
        this.studentCentreOptOut = studentCentreOptOut;
    }
    
    public float getTuition(){
        float tuition = 4250;
        if(insuranceOptOut == true)
        {
            tuition = 4015;
        }
        if(studentCentreOptOut == true)
        {
            tuition = 4125;
        }
        return tuition;
    }
    
    public String record(){
        return this.getLastName() + " " + this.getFirstName() +" " + this.getMiddleInit() +" " + 
               this.getBirthDate().toString() +" " + this.getGender() + " " +this.getStudentNumber() + " "+
               this.getEmail() + " " +this.getRegistrationDate().toString() + " " +
               this.isInsuranceOptOut() + " "+this.isStudentCentreOptOut();
    }
    
    
}
