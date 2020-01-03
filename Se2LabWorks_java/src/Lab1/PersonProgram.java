/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;


/**
 *
 * @author zhou6718
 */import java.util.*;
public class PersonProgram 
{
    static Scanner keyboard = new Scanner(System.in); 
    static Person[] people = new Person[5];
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
        people[0] = new Person("Smith", "John", 'T', "80/09/23");
        people[1] = new Person("One", "Oner", 'O', "81/02/23");
        people[2] = new Person("Two", "Twoer", 'I', "82/03/23");
        people[3] = new Person("Three", "Threer", 'W', "83/04/23");
        people[4] = new Person("Four", "Fourer", 'F', "84/06/23");
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
    
    public static void menuOption1()
    {
        for(int i = 0; i < people.length; i++ )
        {
            System.out.println((i+1) + " " + people[i].getFullName());
        }
        System.out.println("------------------------------");
    }
    public static void menuOption2()
    {
        System.out.println("Please choose a person: ");
        menuOption1();
        int index = keyboard.nextInt();
        System.out.println("Person Data\n" + "Full Name: " + people[index-1].getFullName() +"\n"
                            + "Birth Date: " + people[index -1].getBirthDate());
        System.out.println("-----------------------------");
    }
    public static void menuOption3()
    {
        System.out.println("1.	First Name\n" +
                           "2.	Last Name\n" +
                           "3.	Middle Initial\n" +
                           "4.	Birth Date\n" +
                           "5.	Cancel");
        int choice = keyboard.nextInt();
        switch(choice)
        {
            case 1: 
                System.out.println("Please choose who you want to edit: ");
                menuOption1();
                int index = keyboard.nextInt();
                System.out.println("Please enter a new first name: ");
                String newFirstName = keyboard.next();
                people[index-1].setFirstName(newFirstName);
                System.out.println("Edit success! The new person information is:\n" );
                menuOption1();
                break;
            case 2: 
                System.out.println("Please choose who you want to edit: ");
                menuOption1();
                index = keyboard.nextInt();
                System.out.println("Please enter a new last name: ");
                String newLastName = keyboard.next();
                people[index-1].setLastName(newLastName);
                System.out.println("Edit success! The new person information is:\n" );
                menuOption1();
                break;
            case 3: 
                System.out.println("Please choose who you want to edit: ");
                menuOption1();
                index = keyboard.nextInt();
                System.out.println("Please enter a new middle: ");
                char newMiddle = keyboard.next().charAt(0);
                people[index-1].setMiddleInit(newMiddle);
                System.out.println("Edit success! The new person information is:\n" );
                menuOption1();
                break;
            case 4:
                System.out.println("Please choose who you want to edit: ");
                menuOption1();
                index = keyboard.nextInt();
                System.out.println("Please enter a new date of birth: ");
                String newBirthDate = keyboard.next();
                people[index-1].setBirthDate(newBirthDate);
                System.out.println("Edit success! The new person information is:\n" );
                menuOption1();
                break;
            case 5:break;
        }
    }
}
