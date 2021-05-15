/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import User.Authentication.ValidateEmail;
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
public class EmailCheck {
    ValidateEmail validateemail;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    
    public EmailCheck() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validateemail=new ValidateEmail();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testEmail1(){
        try {
            //data set
            String email="dharmarajthanait36@gmail.com";
           result1=validateemail.validateUserEmail(email);
            assertTrue(result1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testEmail2(){
        try {
            //data set
            String email="dharmaragmail.com";
           result2=validateemail.validateUserEmail(email);
            assertFalse(result2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testEmail3(){
        try {
            //data set
            String email=" ";
           result3=validateemail.validateUserEmail(email);
            assertFalse(result3);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
