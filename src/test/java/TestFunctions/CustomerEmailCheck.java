/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import Customer.Authentication.ValidateCustomerEmail;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dharm
 */
public class CustomerEmailCheck {
    ValidateCustomerEmail validatecustomeremail;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    public CustomerEmailCheck() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validatecustomeremail=new  ValidateCustomerEmail();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testEmail1(){

        try {
            
            //data set
            String email="dharmarajthanait25@gmail.com";
            result1=validatecustomeremail.validateCustomerEmail(email);
            assertTrue(result1);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @Test
    public void testEmail2(){

        try {
            
            //data set
            String email="dharmarajtha@gmail.com";
            result2=validatecustomeremail.validateCustomerEmail(email);
            assertFalse(result2);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @Test
    public void testEmail3(){

        try {
            
            //data set
            String email=" ";
            result3=validatecustomeremail.validateCustomerEmail(email);
            assertFalse(result3);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
}
