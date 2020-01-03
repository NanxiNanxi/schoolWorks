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
public class ExternalTicket extends Ticket {
    private Address contactInfo;
    private String companyName;

    public ExternalTicket() {}

    public ExternalTicket(Address contactInfo, String companyName, String description, Date submittedDate) {
        super(description, submittedDate);
        this.contactInfo = contactInfo;
        this.companyName = companyName;
    }

    
    /**
     * @return the contactInfo
     */
    public Address getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(Address contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void shortDisplay(){
        System.out.println(getTicketId()+": "+getDateSubmitted()+" - "+getCompanyName()+", "+getStatus());
    }
    
    public void longDisplay(){
        System.out.println("Ticket Id: "+getTicketId());
        System.out.println("Date Submitted: "+getDateSubmitted());
        System.out.println("Assigned To: "+getCompanyName());
        System.out.println("Description: "+getTicketDescription());
        System.out.println("Status: "+getStatus());
        if(isCompleted()){
            System.out.println("Date Completed: "+getDateCompleted());
        }      
        System.out.println("Contact Info: "+contactInfo);
    }
    
    
    /*ShortDisplay should display:  
2000: 10/11/2014 – Fabulous Floors, Open
Long display should show a list of all information:
ID: 2000
Date Submitted: 10/10/2014
Assigned To: Fabulous Floors
Description: Repair broken floor tiles in cafeteria
Status: Closed
Date Completed:  11/24/2014
Contact Info:
123 Main Street
PO Box 20032
Moose Jaw, SK
S7Y 3J6
(306) 691-1245
*/
}
