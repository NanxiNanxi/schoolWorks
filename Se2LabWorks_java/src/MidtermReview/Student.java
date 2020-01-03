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
public abstract class Student extends Person implements Comparable{
    private int studentNumber;
    private String email;
    private Date registrationDate;
    public Student(){}

    public Student(String firstName, String lastName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate) {
        super(firstName, lastName, middleInit, birthDate, gender);
        this.studentNumber = studentNumber;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public abstract float getTuition();
    public abstract String record();
    public int compareTo(Object o){
        Student s = (Student)o;
        if(this.getStudentNumber() > s.getStudentNumber()){
            return 1;
        }
        if(this.getStudentNumber() == s.getStudentNumber()){
            return 0;
        }
        return -1;
    }
    
}
