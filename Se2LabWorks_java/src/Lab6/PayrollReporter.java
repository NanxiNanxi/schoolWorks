/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class PayrollReporter {

    static Employee[] employees;
    static Scanner k = new Scanner(System.in);

    public static void main(String[] args) {
        getData();
        int choice = 0;
        while (choice != 7) {
            choice = showMenu();
            executeChoice(choice);
        }
    }

    public static void getData() {
        employees = new Employee[10];
        employees[0] = new SalaryEmployee("John", "Smith", 'T', new Date(6, 24, 80), 100101, 1, 12, 2894.54f);
        employees[1] = new SalaryEmployee("Sue", "Jones", 'A', new Date(4, 13, 84), 100102, 1, 15, 3110.0f);
        employees[2] = new HourlyEmployee("Marg", "Williams", 'C', new Date(1, 28, 70), 100103, 3, 15, 25.0f, 81f);
        employees[3] = new SalaryEmployee("Beth", "Davies", 'D', new Date(2, 3, 76), 200101, 3, 15, 2843.5f);
        employees[4] = new SalaryEmployee("Jake", "Stewart", 'A', new Date(9, 18, 68), 100201, 1, 0, 2999.0f);
        employees[5] = new HourlyEmployee("Alice", "McWilliams", 'F', new Date(10, 9, 80), 300203, 1, 0, 27.0f, 88f);
        employees[6] = new HourlyEmployee("Mike", "Klauss", 'M', new Date(12, 12, 76), 300213, 2, 0, 30.0f, 80f);
        employees[7] = new HourlyEmployee("Samuelle", "Chau", 'D', new Date(8, 23, 86), 400213, 2, 12, 22.0f, 85f);
        employees[8] = new HourlyEmployee("Mitch", "Flynn", 'A', new Date(7, 28, 78), 990223, 3, 15, 100.0f, 80f);
        employees[9] = new SalaryEmployee("Andrea", "Bouchard", 'S', new Date(3, 20, 85), 400023, 3, 12, 3900.0f);
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
        float totalWage0 = 0;
        float totalWage12 = 0;
        float totalWage15 = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getProjectNo() == 0) {
                totalWage0 += employees[i].getEarnings();
            }
            if (employees[i].getProjectNo() == 12) {
                totalWage12 += employees[i].getEarnings();
            }
            if (employees[i].getProjectNo() == 15) {
                totalWage15 += employees[i].getEarnings();
            }
        }
        System.out.println("Project#0 Total Wage: $" + totalWage0);
        System.out.println("Project#12 Total Wage: $" + totalWage12);
        System.out.println("Project#15 Total Wage: $" + totalWage15);
        System.out.println("------------------------------");
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
