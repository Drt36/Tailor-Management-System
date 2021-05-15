/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import Customer.Authentication.ValidateCustomerUsername;
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
public class CustomerUsernameCheck {
    ValidateCustomerUsername validatecustomerusername;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    public CustomerUsernameCheck() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validatecustomerusername=new ValidateCustomerUsername();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testUsername1(){

        try {
            //data set
            String username="cus_1";
            result1=validatecustomerusername.validateCustomerUsername(username);
            assertTrue(result1);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Test
    public void testUsername2(){

        try {
            //data set
            String username="cus1565454/";
            result2=validatecustomerusername.validateCustomerUsername(username);
            assertFalse(result2);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Test
    public void testUsername3(){

        try {
            //data set
            String username=" ";
            result3=validatecustomerusername.validateCustomerUsername(username);
            assertFalse(result3);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerUsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
