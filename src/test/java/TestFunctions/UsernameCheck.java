/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import User.Authentication.ValidateUsername;
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
public class UsernameCheck {
    ValidateUsername validateusername;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    
    public UsernameCheck() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validateusername=new ValidateUsername();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testUsername1(){
        try {
            //data set
            String username="admin";
           result1=validateusername.validateUsername(username);
            assertTrue(result1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    @Test
    public void testUsername2(){
        try {
            //data set
            String username="admin4545";
           result2=validateusername.validateUsername(username);
            assertFalse(result2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    @Test
    public void testUsername3(){
        try {
            //data set
            String username=" ";
           result3=validateusername.validateUsername(username);
            assertFalse(result3);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsernameCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
