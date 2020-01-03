/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp258;

import java.util.Date;

/**
 *
 * @author zhou6718
 */
public class Comp258 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ticket t1 = new InternalTicket("Fix ceiling tile in 4.240",new Date(System.currentTimeMillis()) ,"Mike Barcley");
        t1.shortDisplay();
        System.out.println("========================"); 
        t1.longDisplay();
        
        Address a1 = new Address("123", "234st", "Regina", "SK", "SJJJJJ","12233441");
        System.out.println("*********************");
        
        Ticket t2 = new ExternalTicket(a1, "companyName", "xxxoodescription", new Date(System.currentTimeMillis()));
         t2.shortDisplay();
        System.out.println("========================"); 
        t2.longDisplay();
        System.out.println(t2.getDateSubmitted());
        // TODO code application logic here
    }
    
}
