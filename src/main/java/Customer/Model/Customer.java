/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Model;

/**
 *
 * @author dharm
 */
public class Customer {
    String customer_username;
    String customer_fullname;
    String customer_email;
    String customer_contact;
    String customer_address;
    String customer_dateofbirth;
    String customer_gender;
    
     public Customer() {
        
    }
     
    public Customer(String customer_username, String customer_fullname, String customer_email, String customer_contact, String customer_address, String customer_dateofbirth, String customer_gender) {
        this.customer_username = customer_username;
        this.customer_fullname = customer_fullname;
        this.customer_email = customer_email;
        this.customer_contact = customer_contact;
        this.customer_address = customer_address;
        this.customer_dateofbirth = customer_dateofbirth;
        this.customer_gender = customer_gender;
    }
    
    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_fullname() {
        return customer_fullname;
    }

    public void setCustomer_fullname(String customer_fullname) {
        this.customer_fullname = customer_fullname;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_dateofbirth() {
        return customer_dateofbirth;
    }

    public void setCustomer_dateofbirth(String customer_dateofbirth) {
        this.customer_dateofbirth = customer_dateofbirth;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }
    
    
}
