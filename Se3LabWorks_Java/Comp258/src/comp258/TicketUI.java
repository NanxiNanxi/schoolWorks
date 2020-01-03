/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp258;

import java.util.Scanner;
/**
 *
 * @author zhou6718
 */
public class TicketUI {
    
    Scanner input = new Scanner(System.in);
    ticketUtilities tu = new ticketUtilities();
   
    
    public static void main(String[] args) {
      TicketUI tui = new TicketUI();
      boolean stop = false;
      while(stop == false){
          tui.showMenu();
         stop=tui.processMenu();
      }
        System.out.println("Thank you for using TicketTron 2020!");
      
    }
    
    public void showMenu(){
        System.out.println("0. Add a ticket");
        System.out.println("1. Display all tickets");
        System.out.println("2. Show open tickets only");
        System.out.println("3. Show a single ticket");
        System.out.println("4. Close a ticket by ID");
        System.out.println("5. Exit");
        System.out.print(">>  ");
    }
    
    public boolean processMenu(){
       
        int choice = input.nextInt();
        boolean stop = false;
        if (choice==0) {
            tu.addTicket();
            tu.displayShortTickets();
        }
        if (choice == 1) {
            tu.displayShortTickets();
        }
        if (choice ==2) {
            tu.displayOpenTicket();
        }
        if (choice ==3) {
            System.out.println("Please enter ticket number\n>>");
            int ticketNo = input.nextInt();
            tu.displayLongTickets(ticketNo);
        }
        if (choice==4) {
            System.out.println("Enter a ticket ID");
            int ticketID = input.nextInt();
            if (tu.closeTicketByNumber(ticketID)) {
                System.out.println("Ticket "+ticketID+" has been closed.");
            }
            else{
                System.out.println("Error! No ticket with this ID has been found!");
            }
            
        }
        
        if (choice==5) {
          stop=true;
        }
       
        return stop;
        
    }
    
}
