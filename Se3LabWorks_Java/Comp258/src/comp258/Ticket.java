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
public abstract class Ticket {
    private static int TicketCount;
    private int ticketId;
    private String ticketDescription;
    private Date dateSubmitted;
    private Date dateCompleted;
    private boolean isCompleted;
    
    public Ticket(){
        TicketCount++;
        ticketId = TicketCount;
        if (this instanceof ExternalTicket) {
            ticketId+=2000;
        }
        if (this instanceof InternalTicket) {
            ticketId+=1000;
        }
    }
    
    public Ticket(String description, Date dateSubmitted){
        TicketCount++;
        ticketId = TicketCount;
         if (this instanceof ExternalTicket) {
            ticketId+=2000;
        }
        if (this instanceof InternalTicket) {
            ticketId+=1000;
        }
        this.setDateSubmitted(dateSubmitted);
        this.setTicketDescription(description);
    }

    /**
     * @return the TicketCount
     */
    public static int getTicketCount() {
        return TicketCount;
    }

    /**
     * @param aTicketCount the TicketCount to set
     */
    public static void setTicketCount(int aTicketCount) {
        TicketCount = aTicketCount;
    }

    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the ticketDescription
     */
    public String getTicketDescription() {
        return ticketDescription;
    }

    /**
     * @param ticketDescription the ticketDescription to set
     */
    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    /**
     * @return the dateSubmitted
     */
    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * @param dateSubmitted the dateSubmitted to set
     */
    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    /**
     * @return the dateCompleted
     */
    public Date getDateCompleted() {
        return dateCompleted;
    }

    /**
     * @param dateCompleted the dateCompleted to set
     */
    public void setDateCompleted(Date dateCompleted) {
        if (isCompleted) {
             this.dateCompleted = dateCompleted;
        }
        else{
            System.out.println("Error: Ticket is opened!");
        }
       
    }

    /**
     * @return the isCompleted
     */
    public boolean isCompleted() {
       
        return isCompleted;
    }
    
    public String getStatus(){
        if(isCompleted){
            return "closed";
        }
        else{
            return "opened";
        }
    }

    /**
     * @param isCompleted the isCompleted to set
     */
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
   
    public abstract void shortDisplay();
    public abstract void longDisplay();
    
    
}
