/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mid_Try2;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class RegistrarProgram {
   static Scanner k = new Scanner(System.in);
   static Student[] Students;
   static int idTest;

    public static void main(String[] args) {
        Students = new RegistrarProgram().getData("C:\\Users\\Administrator\\Desktop\\COMP233\\examTestData.txt");
        Arrays.sort(Students);
        int choice = 0;
        while(choice != 6){
            choice = showMenu();
            executeChoice(choice);
        }
        
        
    }
   
    
    
    public Student[] getData(String fileName){
        try{
            k = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found!");
        }
        try{
            int size = k.nextInt();
            Students = new Student[size];
            int index = 0;
            
            while(k.hasNext())
            {
            boolean isRecorded = false;
            String stuType = k.next();
            if(stuType.equals("P"))
                {
                    Students[index] = new ParTimeStudent(k.next(), k.next(),k.next().charAt(0), 
                                      new Date(k.nextInt(), k.nextInt(), k.nextInt()),k.next().charAt(0),k.nextInt(),k.next(), 
                                      new Date(k.nextInt(),k.nextInt(),k.nextInt()),k.nextInt());
                    isRecorded = true;
                }
               if(stuType.equals("F"))
                {
                    Students[index] = new FullTimeStudent(k.next(), k.next(),k.next().charAt(0), 
                                      new Date(k.nextInt(), k.nextInt(), k.nextInt()),k.next().charAt(0),k.nextInt(),k.next(), 
                                      new Date(k.nextInt(),k.nextInt(),k.nextInt()),k.nextBoolean(), k.nextBoolean());
                    isRecorded = true;

                }
                if(isRecorded = true){
                    System.out.println("Student Added");
                }
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
        return Students;
    } 
    
    public static int showMenu()
    {
        int choice;
        System.out.println("1. Display name and tuition fees for all students in sorted order\n" +
                           "2. Display students by year \n" +
                           "3. Display Student Centre Member Mail List \n" +
                           "4. Part Time to Full Time Transfer\n" +
                           "5. Reload Data \n" +
                           "6. Exit the program\n" +
                           "Choice:");
        k = new Scanner(System.in);
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
                break;
            case 7:
                test();
                break;
        }
    }
    public static void menuOption1(){
        System.out.println("Student Number\t\tName\t\t\tTuition");
        System.out.println("————————————————————————————————");
        for (int i = 0; i < Students.length; i++) {
            System.out.println(Students[i].getStudentNumber() + "\t\t" +
                               Students[i].getFirstName() + ", " + Students[i].getLastName()+ " " + Students[i].getMiddleInit() + 
                               ".\t\t\t" +Students[i].getTuition() );
        }
    }
    public static void menuOption2(){
        System.out.println("1. Junior\n" +
                            "2. Intermediate\n" +
                            "3. Senior\n" +
                            "Please enter a year:");
        int opt = k.nextInt();
        switch(opt){
            case 1:
                System.out.println("Junior List:");
                System.out.println("Student NO.\t\tName");
                for(int i =0; i < Students.length;i++)
                {
                    if(Students[i].getRegistrationDate().getYear() == 2013)
                    {
                         System.out.println(Students[i].getStudentNumber() + "\t\t" + 
                                            Students[i].getLastName() + ", "+Students[i].getFirstName() + " " + 
                                            Students[i].getMiddleInit() + ".");
                    }
                }
                break;
            case 2:
                System.out.println("Intermediate List:");
                System.out.println("Student Number\t\tName");
                  for (int i = 0; i < Students.length; i++) 
                {
                    
                     if(Students[i].getRegistrationDate().getYear() == 2012)
                     {
                         
                         System.out.println(Students[i].getStudentNumber() + "\t\t" + 
                                            Students[i].getLastName() + ", "+Students[i].getFirstName() + " " + 
                                            Students[i].getMiddleInit() + ".");
                     }
                    
                }
                  break;
            case 3:
                System.out.println("Senior List:");
                System.out.println("Student Number\t\tName");
                  for (int i = 0; i < Students.length; i++) 
                {
                     if(Students[i].getRegistrationDate().getYear() == 2011)
                     {
                         
                         System.out.println(Students[i].getStudentNumber() + "\t\t" + 
                                            Students[i].getLastName() + ", "+Students[i].getFirstName() + " " + 
                                            Students[i].getMiddleInit() + ".");
                     }
                    
                }
                  break;
        }
        }
    public static void menuOption3(){
         System.out.println("Student center mail list:");
        for (int i = 0; i < Students.length; i++) 
        {
            if(Students[i] instanceof FullTimeStudent)
            {
                if(((FullTimeStudent)Students[i]).isStudentCentreOptOut() == false)
                { 
                    System.out.println(((FullTimeStudent)Students[i]).getEmail());
                }
            }
        }
    }
    
    public static void menuOption4(){
        System.out.println("Please enter a student number: ");
        int tempNum = k.nextInt();
        for (int i = 0; i < Students.length; i++) {
            if(Students[i] instanceof ParTimeStudent)
            {
                if(Students[i].getStudentNumber() == tempNum)
                {
                    Students[i] = new FullTimeStudent(Students[i].getLastName(), Students[i].getFirstName(), Students[i].getMiddleInit(), 
                                                      Students[i].getBirthDate(), Students[i].getGender(), Students[i].getStudentNumber(), Students[i].getEmail(),
                                                      Students[i].getRegistrationDate(),false,true);
                     System.out.println(Students[i].getLastName() + ", " + Students[i].getFirstName() + " " + Students[i].getMiddleInit() + ". is now a Full Time Student with a student Center Membership");
                }
            }
        }
    }
    
    public static void menuOption5(){
        try{
               FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\COMP233\\examTestData.txt", false);
               String size = String.valueOf(Students.length);
               fw.write(size);
               fw.write("\r\n");
                for (int i = 0; i < Students.length; i++) 
                {
                    if(Students[i] instanceof FullTimeStudent)
                    {
                        fw.write("F ");
                    }
                    if(Students[i] instanceof ParTimeStudent)
                    {
                        fw.write("P ");
                    }
                    fw.write(Students[i].record());
                    fw.write("\r\n");
                }
                fw.flush();
                fw.close();
            }
        catch (IOException e) {
        e.printStackTrace();
    }
        }
    
public static void test(){
    for (int i = 0; i < Students.length; i++) {
        System.out.println(Students[i].getTestID());
    }
}
    
    
}
    
    
    

    
    
    
    



