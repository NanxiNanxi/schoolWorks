/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5_4;

import Lab5.*;
import Lab3.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import sun.applet.resources.MsgAppletViewer;
import java.io.FileWriter;
import java.io.IOException;

public class PersonFileHandler 
{
    static Person[] people;
    static Scanner keyboard = new Scanner(System.in);
    
 
    public static void main(String[] args) 
    {
        people = new PersonFileHandler().getData("j:\\COMP233\\COM233\\build\\classes\\Lab5\\233PersonTestData.txt");
        int choice = 0;
        while(choice != 5)
        {
            choice = showMenu();
            executeChoice(choice); 
        }    
    }
   
    
//   public static void getData()
//    {
//        Date[] birthday = new Date[5];
//        birthday[0] = new Date(23,9,80);
//        birthday[1] = new Date(23,1,81);
//        birthday[2] = new Date(23,2,82);
//        birthday[3] = new Date(23,3,83);
//        birthday[4] = new Date(23,4,84);
//        people[0] = new Person("Smith", "John", 'T', birthday[0]);
//        people[1] = new Person("One", "Oner", 'O',birthday[1]);
//        people[2] = new Person("Two", "Twoer", 'I', birthday[2]);
//        people[3] = new Person("Three", "Threer", 'W', birthday[3]);
//        people[4] = new Person("Four", "Fourer", 'F', birthday[4]);
//    }
    public static int showMenu()
    {
        int choice;
        System.out.println("1.	Display all names\n" +
                           "2.	Display info for person by number\n" +
                           "3.	Edit information for person by number\n" +
                           "4.  Add a new person\n" +
                           "5.	Save all\n" +
                           "Choice:");
        keyboard = new Scanner(System.in);
        choice = keyboard.nextInt();
        return choice;    
    }
    public static void executeChoice(int choice)
    {
       
            switch(choice)
        {
            case 1: 
                menuOption1();
                break;
            case 2: 
                menuOption2();
                break;
            case 3: 
                menuOption3();
                break;
            case 4:
                menuOption4();
            case 5:
                saveAll();
                break;
        }
    }
    
   public static void menuOption1()
    {
        for(int i = 0; i < people.length; i++ )
        {
            System.out.println((i+1) + " " + people[i].toString());
        }
        System.out.println("------------------------------");
    }
    public static void menuOption2()
    {
        System.out.println("Please choose a person: ");
        menuOption1();
        int index = keyboard.nextInt();
       while(index > 5 || index < 1) 
        {
            System.out.println("Please enter the valid data!");
            System.out.println("Please choose a person: ");
            menuOption1();
            index = keyboard.nextInt();
        }
        if(index <= 5 && index > 0)
        {
            System.out.println("Person Data\n" + "Full Name: " + people[index-1].toString() +"\n"
                            + "Birth Date: " + people[index -1].getBirthDate());
            System.out.println("-----------------------------");
        }
    }
    public static void menuOption3()
    {
        System.out.println("1.	First Name\n" +
                           "2.	Last Name\n" +
                           "3.	Middle Initial\n" +
                           "4.	Birth Date\n" +
                           "5.	Cancel");
        int choice = keyboard.nextInt();
        while(choice > 5 || choice < 1) 
        {
            System.out.println("Please enter the valid data!");
            System.out.println("1.	First Name\n" +
                           "2.	Last Name\n" +
                           "3.	Middle Initial\n" +
                           "4.	Birth Date\n" +
                           "5.	Cancel");
            choice = keyboard.nextInt();
        }
       if(choice <= 5 && choice > 0)
        {
            switch(choice)
            {
                case 1: 
                    
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    int index = keyboard.nextInt();
                     while(index > 7 || index < 1)
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose who you want to edit: ");
                        menuOption1();
                        index = keyboard.nextInt();
                    }
                    if(index <= 7 && index > 0)
                    {
                        System.out.println("Please enter a new first name: ");
                        String newFirstName = keyboard.next();
                        people[index-1].setFirstName(newFirstName);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    }
                case 2: 
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = keyboard.nextInt();
                     while(index > 7 || index < 1)
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose who you want to edit: ");
                        menuOption1();
                        index = keyboard.nextInt();
                    }
                    if(index <= 7 && index > 0)
                    {
                        System.out.println("Please enter a new last name: ");
                        String newLastName = keyboard.next();
                        people[index-1].setLastName(newLastName);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    }
                case 3: 
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = keyboard.nextInt();
                     while(index > 7 || index < 1)
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose who you want to edit: ");
                        menuOption1();
                        index = keyboard.nextInt();
                    }
                    if(index <= 7 && index > 0)
                    {
                        System.out.println("Please enter a new middle: ");
                        char newMiddle = keyboard.next().charAt(0);
                        people[index-1].setMiddleInit(newMiddle);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    }
                case 4:
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = keyboard.nextInt();
                     while(index > 7 || index < 1)
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose who you want to edit: ");
                        menuOption1();
                        index = keyboard.nextInt();
                    }
                    if(index <= 7 && index > 0)
                    {
                        System.out.println("Please enter a new day of birthday: ");
                        int newDay = keyboard.nextInt();
                        System.out.println("Please enter a new month of birthday: ");
                        int newMonth = keyboard.nextInt();
                        System.out.println("Please enter a new year of birthday: ");
                        int newYear = keyboard.nextInt();
                        Date newBirthday = new Date();
                        newBirthday.setMonth(newMonth);
                        newBirthday.setDay(newDay);
                        newBirthday.setYear(newYear);
                        people[index-1].setBirthDate(newBirthday);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    }
                case 5:break;
            }
        }
    }
    
public Person[] getData(String fileName)
{
        try
        {
            keyboard= new Scanner( new File(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }  
       
        try
        {
            int size = keyboard.nextInt();
            people = new Person[size];
            
            int index=0;		
        while (keyboard.hasNext())
        {
        people[index] = new Person(keyboard.next(), keyboard.next(),keyboard.next().charAt(0), 
                                   new Date(keyboard.nextInt(), keyboard.nextInt(),
                                   keyboard.nextInt())
                                  );
        System.out.println("Person Added");
                index++;      
        }  
            
            
        }
        catch(NoSuchElementException e){
                        System.out.println("File Format Error");
                        //If the file is empty or we read past EOF
        }
        catch(IllegalStateException ise){
                        System.out.println("Error Reading Error");
                        //If the file is deleted or closed before we 
                        //Have a chance to read from it.			
        }	
        
        catch (Exception e) {
            System.out.println("Unknow erro happened!");
        }
        return people;
    }

public static void saveAll()
{
    try{
        FileWriter fw = new FileWriter("J:\\COMP233\\COM233\\build\\classes\\Lab5_4\\personTest.txt", true);
        for(int i = 0; i < people.length;i++)
        {
             fw.write(people[i].writeAsRecord());
             fw.write("\r\n");
        }
        fw.flush();
        fw.close();
       
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
public static void menuOption4()
{
    Person[] tempPeople = new Person[people.length+1];
         System.out.println("Please enter a new first name: ");
         String newFirst = keyboard.next();
         System.out.println("Please enter a new last name: ");
         String newLast = keyboard.next();
         System.out.println("Please enter a new middle name: ");
         char newMiddle = keyboard.next().charAt(0);
         System.out.println("Please enter a new day of birthday: ");
         int newBDay = keyboard.nextInt();
         System.out.println("Please enter a new month of birthday: ");
         int newBMonth = keyboard.nextInt();
         System.out.println("Please enter a new year of birthday: ");
         int newBYear = keyboard.nextInt();
         Date newBirthday = new Date();
         newBirthday.setMonth(newBMonth);
         newBirthday.setDay(newBDay); 
         newBirthday.setYear(newBYear);
        
         System.arraycopy(people,0,tempPeople,0,people.length );
         tempPeople[people.length] = new Person(newFirst,newLast,newMiddle,newBirthday);
         people = tempPeople;
         System.out.println("Edit success! The new person information is:\n" );
         menuOption1();
}
} 

