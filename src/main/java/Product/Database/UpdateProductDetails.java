/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UpdateProductDetails {
    
    //update the product details
     public void updateProductDetails(String product_name,Float product_cost,Float product_paymentforstaff,boolean is_available,String product_description,String product_code,String product_category) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update Products set product_name = ?,product_cost=?,product_paymentforstaff=?,is_available=?,product_description=?,product_category=? where product_code= ?")) {
            preparedStatement.setString(1,product_name);
            preparedStatement.setFloat(2,product_cost);
            preparedStatement.setFloat(3,product_paymentforstaff);
            preparedStatement.setBoolean(4,is_available);
            preparedStatement.setString(5,product_description);
            preparedStatement.setString(6,product_category);
            preparedStatement.setString(7,product_code);
            
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
