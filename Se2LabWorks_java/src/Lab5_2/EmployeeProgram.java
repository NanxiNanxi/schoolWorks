/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5_2;

import Lab4.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class EmployeeProgram {
    static Employee[] employees;
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args) {
        getData();    
        int choice = 0;
        while(choice != 6)
        {
            choice = showMenu();
            executeChoice(choice); 
        }   
    }
    
     public static void getData()
    {
        employees = new Employee[5];
        employees[0] = new Employee("John", "Smith", 'T',new Date(6,24,80), 100101, 2789.0f, new Date(5,22,2001));
        employees[1] = new Employee("One", "Oner", 'O',new Date(1,24,80), 100102, 2889.0f, new Date(1,22,2001));
        employees[2] = new Employee("Two", "Twoer", 'W',new Date(2,24,80), 100103, 2989.0f, new Date(2,22,2001));
        employees[3] = new Employee("Three", "Threeer", 'R',new Date(3,24,80), 100104, 2989.0f, new Date(3,22,2001));
        employees[4] = new Employee("Four", "Fourer", 'F',new Date(4,24,80), 100105, 3000.0f, new Date(4,22,2001));
    }
       public static int showMenu()
    {
        int choice;
        System.out.println("1. Display all the employees\n" +
                           "2. Display info for employee by list number\n" +
                           "3. Display info for employee by employee number\n" +
                           "4. Edit info for employee by employee number\n"+
                           "5. Add a new employee\n" +
                           "6. Save all\n" +
                           "Choice:");
        choice = k.nextInt();
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
                break;
            case 5:
                menuOption5();
                break;
            case 6:
                saveAll();
                break;
        }
    }
    public static void menuOption1()
    {
        for(int i = 0; i < employees.length; i++ )
        {
            System.out.println((i+1) + " " + employees[i].employeeNo +": "+ employees[i].lastName + " " + employees[i].firstName + " " + employees[i].middleInit);
        }
        System.out.println("------------------------------");
    }
     public static void printAll(int index)
    {
        System.out.println(employees[index].toString());
        System.out.println("------------------------------");
    }
     public static void menuOption2()
    {
        System.out.println("Please choose a list number: ");
        menuOption1();
        int index = k.nextInt();
        while(index > 5 || index < 1) 
        {
            System.out.println("Please enter the valid data!");
            System.out.println("Please choose a person: ");
            menuOption1();
            index = k.nextInt();
        }
        if(index <= 5 && index > 0)
        {
            System.out.println("Employee Data\n"  + employees[index-1].toString());
            System.out.println("-----------------------------");
        }
    }
     public static void menuOption3(){
        System.out.println("Please choose an employee number: ");
        menuOption1();
        int index = k.nextInt();
         while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
        {
            System.out.println("Please enter the valid data!");
            System.out.println("Please choose an employee number: ");
            menuOption1();
            index = k.nextInt();
        }
      for (int i = 0; i < employees.length; i++)
      {
          if(index == employees[i].getEmployeeNo())
          {
            System.out.println("Employee Data\n" + "Full Name: " + employees[i].toString());
            System.out.println("-----------------------------");
          }
      }
     }
     public static void menuOption4()
     {
          System.out.println("1. EmployeeNumber" +
                           "2. First Name\n" +
                           "3. Last Name\n" +
                           "4. Middle Initial\n" +
                           "5. Monthly Salary\n" +
                           "6. Birth Date\n"+
                           "7. Hire Date\n" +
                           "8. Exit");
        int choice = k.nextInt();
        while(choice > 8 || choice < 1) 
        {
            System.out.println("Please enter the valid data!");
            System.out.println("1. EmployeeNumber" +
                           "2. First Name\n" +
                           "3. Last Name\n" +
                           "4. Middle Initial\n" +
                           "5. Monthly Salary\n" +
                           "6. Birth Date\n"+
                           "7. Hire Date\n" +
                           "8. Exit");
            choice = k.nextInt();
        }
       if(choice <= 8 && choice > 0)
        {
            switch(choice)
            {
                case 1:
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    int index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                            System.out.println("Please enter a new Employee number: ");
                            int newNumber = k.nextInt();
                            employees[i].setEmployeeNo(newNumber);
                            System.out.println("Edit success! The new person information is:\n" );
                            printAll(i);
                            }
                        }
                     break;

                case 2: 
                   System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                            System.out.println("Please enter a new first name: ");
                            String newFirst = k.next();
                            employees[i].setFirstName(newFirst);
                            System.out.println("Edit success! The new person information is:\n" );
                            printAll(i);
                            }
                        }
                     break;
                     
                    case 3: 
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                            System.out.println("Please enter a new last name: ");
                            String newLast = k.next();
                            employees[i].setLastName(newLast);
                            System.out.println("Edit success! The new person information is:\n" );
                            printAll(i);
                            }
                        }
                     break;
                     
                case 4: 
                     System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                            System.out.println("Please enter a new middle name: ");
                            char newMiddle = k.next().charAt(0);
                            employees[i].setMiddleInit(newMiddle);
                            System.out.println("Edit success! The new person information is:\n" );
                            printAll(i);
                            }
                        }
                     break;
                case 5:
                    System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                            System.out.println("Please enter a new salary: ");
                            float newSalary = k.nextFloat();
                            employees[i].setMonthlySalary(newSalary);
                            System.out.println("Edit success! The new person information is:\n" );
                            printAll(i);
                            }
                        }
                     break;
                case 6:
                      System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                                System.out.println("Please enter a new day of birthday: ");
                                int newDay = k.nextInt();
                                System.out.println("Please enter a new month of birthday: ");
                                int newMonth = k.nextInt();
                                System.out.println("Please enter a new year of birthday: ");
                                int newYear = k.nextInt();
                                Date newBirthday = new Date();
                                newBirthday.setMonth(newMonth);
                                newBirthday.setDay(newDay); 
                                newBirthday.setYear(newYear);
                                employees[i].setBirthDate(newBirthday);
                                System.out.println("Edit success! The new person information is:\n" );
                                printAll(i);
                            }
                        }
                      break;
                   
                    case 7:
                     System.out.println("Please choose who you want to edit: ");
                    menuOption1();
                    index = k.nextInt();
                    while (index != employees[0].getEmployeeNo() && index !=employees[1].getEmployeeNo() && index !=employees[2].getEmployeeNo() && index !=employees[3].getEmployeeNo() && index !=employees[4].getEmployeeNo())
                    {
                        System.out.println("Please enter the valid data!");
                        System.out.println("Please choose an employee number: ");
                        menuOption1();
                        index = k.nextInt();
                    }
                     for (int i = 0; i < employees.length; i++)
                        {
                            if(index == employees[i].getEmployeeNo())
                            {
                                System.out.println("Please enter a new day of hire date: ");
                                int newDay = k.nextInt();
                                System.out.println("Please enter a new month of hire date: ");
                                int newMonth = k.nextInt();
                                System.out.println("Please enter a new year of hire date: ");
                                int newYear = k.nextInt();
                                Date newHireDate = new Date();
                                newHireDate.setMonth(newMonth);
                                newHireDate.setDay(newDay);
                                newHireDate.setYear(newYear);
                                employees[i].setHireDate(newHireDate);
                                System.out.println("Edit success! The new person information is:\n" );
                                printAll(i);
                            }
                        }
                      break;
                case 8:break;
            }
        }
     }
     
     public static void saveAll()
{
    try{
        FileWriter fw = new FileWriter("J:\\COMP233\\COM233\\build\\classes\\Lab5_2\\addEmployeeTest.txt", false);
        String numOfEm = String.valueOf(employees.length);
        fw.write(numOfEm);
        fw.write("\r\n");
        for(int i = 0; i < employees.length;i++)
        {
             
             fw.write(employees[i].writeAsRecord());
             fw.write("\r\n");
        }
        fw.flush();
        fw.close();
       
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
     public static void menuOption5()
     {
         Employee[] tempEmployees = new Employee[employees.length+1];
         System.out.println("Please enter a new first name: ");
         String newFirst = k.next();
         System.out.println("Please enter a new last name: ");
         String newLast = k.next();
         System.out.println("Please enter a new middle name: ");
         char newMiddle = k.next().charAt(0);
         System.out.println("Please enter a new day of birthday: ");
         int newBDay = k.nextInt();
         System.out.println("Please enter a new month of birthday: ");
         int newBMonth = k.nextInt();
         System.out.println("Please enter a new year of birthday: ");
         int newBYear = k.nextInt();
         Date newBirthday = new Date();
         newBirthday.setMonth(newBMonth);
         newBirthday.setDay(newBDay);
         newBirthday.setYear(newBYear);
         System.out.println("Please enter a new Employee number: ");
         int newNumber = k.nextInt();
         System.out.println("Please enter a new salary: ");
         float newSalary = k.nextFloat();
         System.out.println("Please enter a new day of hire date: ");
         int newHDay = k.nextInt();
         System.out.println("Please enter a new month of hire date: ");
         int newHMonth = k.nextInt();
         System.out.println("Please enter a new year of hire date: ");
         int newHYear = k.nextInt();
         Date newHireDate = new Date();
         newHireDate.setMonth(newHMonth);
         newHireDate.setDay(newHDay);
         newHireDate.setYear(newHYear);
         System.arraycopy(employees,0,tempEmployees,0,employees.length );
         tempEmployees[employees.length] = new Employee(newFirst,newLast,newMiddle,newBirthday,newNumber,newSalary,newHireDate);
         employees = tempEmployees;
         System.out.println("Edit success! The new person information is:\n" );
         printAll(employees.length-1);
     }
     
     
}
