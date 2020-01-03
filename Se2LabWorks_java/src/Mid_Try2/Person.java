/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mid_Try2;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author zhou6718
 */
public class Person 
{
    private String lastName;
    private String firstName;
    private char middleInit;
    private Date birthDate;
    private char gender;
    
    public Person()
    {
        
    }
    public Person(String firstName, String lastName,char middleInit, Date birthDate, char gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.middleInit = middleInit;
        this.gender = gender;
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
    public char getGender()
    {
        return gender;
    }
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    public Date getBirthDate()
    {
        return birthDate;
    }
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
    
    public String toString()
    {
        return lastName + "," + firstName +" " + middleInit + " " + birthDate;
    } 
    
    public Date displayFormattedDate()
    {
        return birthDate;
    }
    
    public void getData()
    {
        
    }
//    public String writeAsRecord()
//    {
//        return firstName + " " + lastName + " " + middleInit + " " + birthDate.getMonth() + " " + birthDate.getDay() + " " + birthDate.getYear() +"\n";
//    }
//    public Person[] getData(String fileName)
//{
//        Person[] people = new Person[0];
//        try
//        {
//            keyboard= new Scanner( new File(fileName));
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("File Not Found");
//        }  
//       
//        try
//        {
//            int size = keyboard.nextInt();
//           people = new Person[size];
//            
//            int index=0;		
//        while (keyboard.hasNext())
//        {
//        people[index] = new Person(keyboard.next(), keyboard.next(),keyboard.next().charAt(0), 
//                                   new Date(keyboard.nextInt(), keyboard.nextInt(),
//                                   keyboard.nextInt())
//                                  );
//        System.out.println("Person Added");
//                index++;      
//        }  
//        }
//        catch(NoSuchElementException e){
//                        System.out.println("File Format Error");
//                        //If the file is empty or we read past EOF
//        }
//        catch(IllegalStateException ise){
//                        System.out.println("Error Reading Error");
//                        //If the file is deleted or closed before we 
//                        //Have a chance to read from it.			
//        }	
//        catch (Exception e) {
//            System.out.println("Unknow erro happened!");
//        }
//        return people;
//}
}

