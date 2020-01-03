/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author zhou6718
 */
public class Person 
{
    private String lastName;
    private String firstName;
    private char middleInit;
    private String birthDate;
    
    public Person()
    {
        
    }
    public Person(String lastName, String firstName, char middleInit, String birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.middleInit = middleInit;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
   public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public char getMiddleInit()
    {
        return middleInit;
    }
    public void setMiddleInit(char middleInit)
    {
        this.middleInit = middleInit;
    }
    public String getBirthDate()
    {
        return birthDate;
    }
    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }
    
    public String getFullName()
    {
        return lastName + "," + firstName +" " + middleInit;
    }
}
