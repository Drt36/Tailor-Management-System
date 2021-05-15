/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFunctions;

import Product.Authentication.ValidateProductCode;
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
public class ProductCodeCheck {
    ValidateProductCode validateproductcode;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    public ProductCodeCheck() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validateproductcode=new ValidateProductCode();    
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testProductCheck1(){

        try {
            //data set
            String product_code="pro_1";
            result1=validateproductcode.validateProductCode(product_code);
            assertTrue(result1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }
    @Test
    public void testProductCheck2(){

        try {
            //data set
            String product_code="pro_145458/*/";
            result2=validateproductcode.validateProductCode(product_code);
            assertFalse(result2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }
    @Test
    public void testProductCheck3(){

        try {
            //data set
            String product_code=" ";
            result3=validateproductcode.validateProductCode(product_code);
            assertFalse(result3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCodeCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }


}
