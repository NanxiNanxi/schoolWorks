/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.util.Scanner;

/**
 *
 * @author zhou6718
 */
public class PersonProgramV2 
{
     static Scanner keyboard = new Scanner(System.in); 
     static Person[] people = new Person[5];
     int day;
     int month;
     int year;
     static Date[] birthday = new Date[5];
     static int validChoice;
    public static void main(String[] args) 
    {
        getData();
        int choice = 0;
        while(choice != 4)
        {
            choice = showMenu();
            executeChoice(choice); 
        }    
    }
   
    
    public static void getData()
    {
        birthday[0] = new Date(23,9,80);
        birthday[1] = new Date(23,1,81);
        birthday[2] = new Date(23,2,82);
        birthday[3] = new Date(23,3,83);
        birthday[4] = new Date(23,4,84);
        people[0] = new Person("Smith", "John", 'T', birthday[0]);
        people[1] = new Person("One", "Oner", 'O',birthday[1]);
        people[2] = new Person("Two", "Twoer", 'I', birthday[2]);
        people[3] = new Person("Three", "Threer", 'W', birthday[3]);
        people[4] = new Person("Four", "Fourer", 'F', birthday[4]);
    }
    public static int showMenu()
    {
        int choice;
        System.out.println("1.	Display all names\n" +
                           "2.	Display info for person by number\n" +
                           "3.	Edit information for person by number\n" +
                           "4.	Exit\n" +
                           "Choice:");
        choice = keyboard.nextInt();
        return choice;    
    }
    public static void executeChoice(int choice)
    {
          if(choice > 4 || choice < 1)
            {
                System.out.println("Please enter the valid data!");
            }
         else
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
                }
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
    public static String menuPerson()
    {
        String show = "";
         for(int i = 0; i < people.length; i++ )
        {
            show += (i+1) + " " + people[i].toString()+"\n";
            
        }
        return show +"------------------------------";
    }
    public static void menuOption2()
    {
        validChoice = validData(1, 5, menuPerson());
        
            System.out.println("Person Data\n" + "Full Name: " + people[validChoice-1].toString() +"\n"
                            + "Birth Date: " + people[validChoice -1].getBirthDate());
            System.out.println("-----------------------------");
        
    }
    public static void menuOption3()
    {
        validChoice = validData(1, 5, "1.	First Name\n" +
                           "2.	Last Name\n" +
                           "3.	Middle Initial\n" +
                           "4.	Birth Date\n" +
                           "5.	Cancel");
       
            switch(validChoice)
            {
                case 1: 
                    validChoice = validData(1, 5,menuPerson());
                   
                        System.out.println("Please enter a new first name: ");
                        String newFirstName = keyboard.next();
                        people[validChoice-1].setFirstName(newFirstName);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    
                case 2: 
                    validChoice = validData(1, 5,menuPerson());
                        System.out.println("Please enter a new last name: ");
                        String newLastName = keyboard.next();
                        people[validChoice-1].setLastName(newLastName);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    
                case 3: 
                    validChoice = validData(1, 5,menuPerson());
                    
                        System.out.println("Please enter a new middle: ");
                        char newMiddle = keyboard.next().charAt(0);
                        people[validChoice-1].setMiddleInit(newMiddle);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    
                case 4:
                     validChoice = validData(1, 5,menuPerson());
                        System.out.println("Please enter a new day of birthday: ");
                        int newDay = keyboard.nextInt();
                        System.out.println("Please enter a new month of birthday: ");
                        int newMonth = keyboard.nextInt();
                        System.out.println("Please enter a new year of birthday: ");
                        int newYear = keyboard.nextInt();
                        Date newBirthday = new Date(newDay,newMonth,newYear);
                        people[validChoice-1].setBirthDate(newBirthday);
                        System.out.println("Edit success! The new person information is:\n" );
                        menuOption1();
                        break;
                    
                case 5:break;
            }
        
    }
    public static int validData(int low, int high,String menu)
    {
        int returnData = 0;
        System.out.println(menu);
        System.out.println("Please choose a number: ");
        int choice = keyboard.nextInt();
        while(choice > high || choice < low)
        {
            System.out.println("Please enter the valid data!");
            System.out.println(menu);
            System.out.println("Please choose a number: ");
            choice = keyboard.nextInt();
        }
        if(choice <= high && choice >= low)
        {
            returnData = choice;
        }
        return returnData;
    }
}
