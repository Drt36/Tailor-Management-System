/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import User.Authentication.ValidateUser;
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
public class Login {
    ValidateUser validateuser;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    boolean result4=false;
    boolean result5=false;
    
    public Login(){
        
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validateuser=new ValidateUser();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLogin1(){
      
        try {
            //test data
            String email="dharmarajthanait36@gmail.com";
            String password="Admin123456789";
            
            result1=validateuser.validateUserEmailPassword(email, password);
            
            assertTrue(result1);
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Test
    public void testLogin2(){
      
        try {
            //test data
            String email="dharmarajthanait3@gmail.com";
            String password="Admin123456789";
            
            result2=validateuser.validateUserEmailPassword(email, password);
            
            assertFalse(result2);
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Test
    public void testLogin3(){
      
        try {
            //test data
            String email="dharmarajthanait36@gmail.com";
            String password="Admin123456";
            
            result3=validateuser.validateUserEmailPassword(email, password);
            
            assertFalse(result3);
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Test
    public void testLogin4(){
      
        try {
            //test data
            String email="dharmarajthghgh@gmail.com";
            String password="Adminjkhjhjhj6";
            
            result4=validateuser.validateUserEmailPassword(email, password);
            
            assertFalse(result4);
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Test
    public void testLogin5(){
      
        try {
            //test data
            String email=" ";
            String password=" ";
            
            result5=validateuser.validateUserEmailPassword(email, password);
            
            assertFalse(result5);
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
