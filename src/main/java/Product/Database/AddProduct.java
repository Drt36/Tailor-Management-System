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
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddProduct {
    public void addProduct(Product product) throws ClassNotFoundException{
        
                       String INSERT_USERS_SQL = "INSERT INTO products" +
                            "  (product_code,product_name,product_cost,product_paymentforstaff,is_available,product_description,product_category) VALUES " +"(?,?,?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,product.getProduct_code());
                            preparedStatement.setString(2,product.getProduct_name());
                            preparedStatement.setFloat(3,product.getProduct_cost());
                            preparedStatement.setFloat(4,product.getProduct_paymentforstaff());
                            preparedStatement.setBoolean(5,product.isIs_available());
                            preparedStatement.setString(6,product.getProduct_description());
                            preparedStatement.setString(7,product.getProduct_category());
                           
                      
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
    
}
