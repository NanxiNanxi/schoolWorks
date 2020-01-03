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
public class InternalTicket extends Ticket {
    private String assignedTo;

    public InternalTicket() {
    }

    public InternalTicket(String description, Date submittedDate, String assingedTo) {
        super(description, submittedDate);
        this.assignedTo = assingedTo;
    }
    

    /**
     * @return the assignedTo
     */
    
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    public void shortDisplay(){
        System.out.println(getTicketId()+ ": "+getDateSubmitted()+" - "+assignedTo+", "+getStatus());
    }
    
    public void longDisplay(){
        System.out.println("Ticket Id: "+getTicketId());
        System.out.println("Date Submitted: "+getDateSubmitted());
        System.out.println("Assigned To: "+assignedTo);
        System.out.println("Description: "+getTicketDescription());
        System.out.println("Status: "+getStatus());
        if(isCompleted()){
            System.out.println("Date Completed: "+getDateCompleted());
        }        
    }
}
