/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Database;

import Product.Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dharm
 */
public class AllProductList {
    //all product list
    public List < Product > selectAllProducts() {

        
            List < Product > products = new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from products ")
                    
                ) 
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String product_code= rs.getString("product_code");
                    String product_name = rs.getString("product_name");
                    Float product_cost = rs.getFloat("product_cost");
                    Float product_paymentforstaff = rs.getFloat("product_paymentforstaff");
                    Boolean is_available=rs.getBoolean("is_available");
                    String product_description= rs.getString("product_description");
                    String product_category=rs.getString("product_category");
                    
                    products.add(new Product( product_code,product_name,product_cost,product_paymentforstaff,is_available,product_description,product_category));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return products;
    }
    
    
    //searched product list
    public List < Product > searchAllProducts(String inputdata) {

        
            List < Product > products = new ArrayList < > ();
            
            // Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from products where  product_code= ? OR product_name=? ")){
                preparedStatement.setString(1,inputdata);  
                preparedStatement.setString(2,inputdata);    
                
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String product_code= rs.getString("product_code");
                    String product_name = rs.getString("product_name");
                    Float product_cost = rs.getFloat("product_cost");
                    Float product_paymentforstaff = rs.getFloat("product_paymentforstaff");
                    Boolean is_available=rs.getBoolean("is_available");
                    String product_description= rs.getString("product_description");
                    String product_category=rs.getString("product_category");
                    
                    
                    products.add(new Product( product_code,product_name,product_cost,product_paymentforstaff,is_available,product_description,product_category));
                }
            }
            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return products;
    }
    
}
