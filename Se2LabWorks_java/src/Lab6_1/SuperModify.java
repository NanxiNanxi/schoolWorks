/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6_1;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class SuperModify {
    static Project[] projects = new Project[4];
    static Employee[] employees;
    static Scanner k = new Scanner(System.in);

    public static void main(String[] args) {
        projects[0] = new Project(12, "Payroll Reporter");
        projects[1] = new Project(0, "Unassigned");
        projects[2] = new Project(9, "Softco Salt Calculator");
        projects[3] = new Project(15, "OT Calculator");
        
        getData();
        Arrays.sort(employees);
        Arrays.sort(projects);
        int choice = 0;
        while (choice != 7) {
            choice = showMenu();
            executeChoice(choice);
        }
    }

    public static void getData() {
      
        employees = new Employee[10];
        employees[0] = new SalaryEmployee("John", "Smith", 'T', new Date(6, 24, 80), 100101, 1, projects[0].getProjectNo(), 2894.54f);
        employees[1] = new SalaryEmployee("Sue", "Jones", 'A', new Date(4, 13, 84), 100102, 1, projects[3].getProjectNo(), 3110.0f);
        employees[2] = new HourlyEmployee("Marg", "Williams", 'C', new Date(1, 28, 70), 100103, 3, projects[3].getProjectNo(), 25.0f, 81f);
        employees[3] = new SalaryEmployee("Beth", "Davies", 'D', new Date(2, 3, 76), 200101, 3, projects[3].getProjectNo(), 2843.5f);
        employees[4] = new SalaryEmployee("Jake", "Stewart", 'A', new Date(9, 18, 68), 100201, 1, projects[1].getProjectNo(), 2999.0f);
        employees[5] = new HourlyEmployee("Alice", "McWilliams", 'F', new Date(10, 9, 80), 300203, 1, projects[1].getProjectNo(), 27.0f, 88f);
        employees[6] = new HourlyEmployee("Mike", "Klauss", 'M', new Date(12, 12, 76), 300213, 2, projects[1].getProjectNo(), 30.0f, 80f);
        employees[7] = new HourlyEmployee("Samuelle", "Chau", 'D', new Date(8, 23, 86), 400213, 2, projects[0].getProjectNo(), 22.0f, 85f);
        //change projectNo from 15 to 9
        employees[8] = new HourlyEmployee("Mitch", "Flynn", 'A', new Date(7, 28, 78), 990223, 3, projects[2].getProjectNo(), 100.0f, 80f);
        employees[9] = new SalaryEmployee("Andrea", "Bouchard", 'S', new Date(3, 20, 85), 400023, 3, projects[0].getProjectNo(), 3900.0f);
    }

    public static int showMenu() {
        int choice;
        System.out.println("1. Display all earnings for employees\n"
                + "2. Display all earnings for a project number\n"
                + "3. Display all earnings for a department number\n"
                + "4. Display wage costs for all projects\n"
                + "5. Display wage costs for all departments\n"
                + "6. Display overtimes expenses\n"
                + "7. Exit\n"
                + "Choice:");
         System.out.println("------------------------------");
        choice = k.nextInt();
        return choice;
    }

    public static void executeChoice(int choice) {

        switch (choice) {
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
                menuOption6();
                break;
            case 7:
                break;
        }
    }

    public static void menuOption1() {
//       Arrays.sort(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println((i + 1) + ". " + employees[i].toString());  
        }
        System.out.println("------------------------------");
    }

    public static void menuOption2() {
        System.out.println("Please enter a project number: ");
        int projectNum = k.nextInt();
        while (projectNum != 0 && projectNum != 12 && projectNum != 15) {
            System.out.println("Please enter the valid data!");
            System.out.println("enter a project number: ");
            projectNum = k.nextInt();
        }

        for (int i = 0; i < employees.length; i++) {
            if (projectNum == employees[i].getProjectNo()) {
                System.out.println("Project#" + projectNum + " " + employees[i].toString());
            }
        }
        System.out.println("------------------------------");
    }

    public static void menuOption3() {
        System.out.println("Please enter a department number: ");
        int departNum = k.nextInt();
        while (departNum != 1 && departNum != 2 && departNum != 3) {
            System.out.println("Please enter the valid data!");
            System.out.println("enter a department number: ");
            departNum = k.nextInt();
        }

        for (int i = 0; i < employees.length; i++) {
            if (departNum == employees[i].getDepartmentNo()) {
                System.out.println("Department#" + departNum + " " + employees[i].toString());
            }
        }
        System.out.println("------------------------------");
    }

    public static void menuOption4() {     
        float[] totalPWage = new float[4];
        for (int i = 0; i < employees.length; i++) {
//            if (employees[i].getProjectNo() == projects[0].getProjectNo()) {
//                totalPWage[0] += employees[i].getEarnings();
//            }
//            if (employees[i].getProjectNo() == projects[1].getProjectNo()) {
//                totalPWage[1]+= employees[i].getEarnings();
//            }
//            if (employees[i].getProjectNo() == projects[2].getProjectNo()) {
//                totalPWage[2] += employees[i].getEarnings();
//            }
//             if (employees[i].getProjectNo() == projects[3].getProjectNo()) {
//                totalPWage[3] += employees[i].getEarnings();
//            }
            for (int j = 0; j < projects.length; j++) {
                 if (employees[i].getProjectNo() == projects[j].getProjectNo()) 
                 {
                    totalPWage[j] += employees[i].getEarnings();
                 }
            }
              
        }
        
        for(int i=0; i<projects.length; i++){
           System.out.println("Project#" + projects[i].getProjectNo() + ": $" + totalPWage[i]); 
        }
        System.out.println("------------------------------");
        
//        System.out.println("Project#0 Total Wage: $" + totalWage0);
//        System.out.println("Project#12 Total Wage: $" + totalWage12);
//        System.out.println("Project#15 Total Wage: $" + totalWage15);
        
    }

    public static void menuOption5() {
        float totalWage1 = 0;
        float totalWage2 = 0;
        float totalWage3 = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNo() == 1) {
                totalWage1 += employees[i].getEarnings();
            }
            if (employees[i].getDepartmentNo() == 2) {
                totalWage2 += employees[i].getEarnings();
            }
            if (employees[i].getDepartmentNo() == 3) {
                totalWage3 += employees[i].getEarnings();
            }
        }
        System.out.println("Department#1 Total Wage: $" + totalWage1);
        System.out.println("Department#2 Total Wage: $" + totalWage2);
        System.out.println("Department#3 Total Wage: $" + totalWage3);
        System.out.println("------------------------------");
    }

    public static void menuOption6() {
        float OTHours = 0;
        float OTEarnings = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof HourlyEmployee) {
                float workedHours = ((HourlyEmployee) employees[i]).getHourswored();
                if (workedHours > 80) {
                    OTHours = workedHours - 80;
                    OTEarnings = (float) ((workedHours - 80) * ((HourlyEmployee) employees[i]).getHourlyRate() * 1.5);
                    System.out.println((count + 1) + ". " + ((HourlyEmployee) employees[i]).lastName + ", " + ((HourlyEmployee) employees[i]).firstName
                            + " " + ((HourlyEmployee) employees[i]).middleInit + "   " + OTHours + "  " + OTEarnings);
                    count++;
                }
            }
        }
         System.out.println("------------------------------");
    }
}
