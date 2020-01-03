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
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String province;
    private String postalcode;
    private String phone;

    private Address(){
        
    }

    public Address(String addressLine1, String addressLine2, String city, String province, String postalcode, String phone) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        setProvince(province);
        this.postalcode = postalcode;
        this.phone = phone;
    }
    
  
    
    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        if (province.length()>2) {
            System.out.println("Error: Province can only be 2 characters!");
        }
        else{
             this.province = province;
        }
       
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postalcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postalcode = postcode;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public  String toString(){
        return addressLine1+"\n"+addressLine2+"\n"+city+", "+province+"\n"+postalcode+"\n"+phone;
    }
}
