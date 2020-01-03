/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp258;

import ArrayManager.ArrayManager;
import com.sun.org.apache.bcel.internal.generic.INVOKEINTERFACE;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author zhou6718
 */
public class ticketUtilities {
    private ArrayManager tickets;
    
    public void getData(){
        
        Address[] addresses = new Address[5];
        Ticket[] tempTickets = new Ticket[6];
        
        addresses[0] = new Address("0123", "234st", "Regina", "SK", "SJJJJJ","12233441");
        addresses[1] = new Address("1Line1", "Line2", "Regina", "SK", "S23ssJ","21421425");
        addresses[2] = new Address("223", "2342dst", "Regina", "SK", "SJJdsfJ","1223546541");
        addresses[3] = new Address("3Line1", "Line2", "Regina", "SK", "S24234J","2523523523");
        addresses[4] = new Address("4123", "234st", "Regina", "SK", "SJdsafdJJ","112325423541");
        
        tempTickets[0] = new InternalTicket("internal 1", new Date(System.currentTimeMillis()),"internal staff 1");
        tempTickets[1] = new InternalTicket("internal 2", new Date(System.currentTimeMillis()),"internal staff 2");
        tempTickets[2] = new InternalTicket("internal 3", new Date(System.currentTimeMillis()),"internal staff 3");
        
        
        tempTickets[3] = new ExternalTicket(addresses[0], "company 1", "External 1", new Date(System.currentTimeMillis()));
        tempTickets[4] = new ExternalTicket(addresses[1], "company 2", "External 2", new Date(System.currentTimeMillis()));
        tempTickets[5] = new ExternalTicket(addresses[2], "company 3", "External 3", new Date(System.currentTimeMillis()));
        
       tickets = new ArrayManager(tempTickets);
        
    }
    
    ticketUtilities(){
        getData();
    }
    
    public void displayShortTickets(){
        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = (Ticket)tickets.getElement(i);
            t.shortDisplay();
        }
        
    }
    public void displayLongTickets(int ticketId){
        if (ticketId < tickets.size()) {
            for(int i = 0; i < tickets.size(); i++){
                Ticket t = (Ticket)tickets.getElement(i);
                if (t.getTicketId()==ticketId) {
                    t.longDisplay();
                }
            }
        }
        else{
        System.out.println("Please enter a valid ticket number");
    }
      
            
    }
    
   public void displayOpenTicket(){
       for (int i = 0; i < tickets.size(); i++) {
            Ticket t = (Ticket)tickets.getElement(i);
            if(!t.isCompleted()){
                t.shortDisplay();
            }
        }
   }
   
   public boolean closeTicketByNumber(int number){
       boolean found = false;
       for(int i = 0; i < tickets.size(); i++){
           Ticket t = (Ticket)tickets.getElement(i);
           if (t.getTicketId()==number) {
               t.setCompleted(true);
               found=true;
           }
       }
       return found;
   }
   public void addTicket(){
     
       System.out.println("1. internal");
       System.out.println("2. external");
       Scanner k = new Scanner(System.in);
       int choice = k.nextInt();
       k.nextLine();
       if (choice==1) {
           System.out.println("Assigned To:");
           String assignedTo = k.nextLine();
           System.out.println("Description:");
           String des = k.nextLine();
           Ticket newT = new InternalTicket(des,new Date(System.currentTimeMillis()), assignedTo);
           tickets.addAt(0, newT);
       }
       if (choice==2) {
           System.out.println("Address line 1:");
           String l1=k.nextLine();
           System.out.println("Address line 2:");
           String l2=k.nextLine();
           System.out.println("Address City:");
           String city=k.nextLine();
           System.out.println("Address Province:");
           String province=k.nextLine();
           System.out.println("Address Postcode:");
           String postcode=k.nextLine();
           System.out.println("Address Phone:");
           String phone=k.nextLine();
           Address contact = new Address(l1, l2, city, province, postcode, phone);
           System.out.println("Company name:");
           String companyName=k.nextLine();
           System.out.println("Description:");
           String descr=k.nextLine();
           Ticket newET = new ExternalTicket(contact, companyName, descr, new Date(System.currentTimeMillis()));
           tickets.addAt(tickets.size()-1,newET);
           
       }
       
   }
            
}
