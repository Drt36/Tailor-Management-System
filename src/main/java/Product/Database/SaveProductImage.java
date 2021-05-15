/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class SaveProductImage {
    String product_code;
    InputStream inputstream;
    
    //save product image
    public void saveProductImage(String product_code,InputStream inputstream) throws ClassNotFoundException{
        this.product_code=product_code;
        this.inputstream=inputstream;

                       String INSERT_SQL = "INSERT INTO productimages" +
                            "(product_code,product_photo) VALUES " +"(?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)){
                            preparedStatement.setString(1,product_code);
                            preparedStatement.setBlob(2,inputstream);
   
                            // Execute the query or update query0
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
                 
       
       }
    
    //update product image
    public void updateProductImage(String product_code,InputStream inputstream) throws ClassNotFoundException{
        this.product_code=product_code;
        this.inputstream=inputstream;
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement("Update productimages set product_photo= ? where product_code= ?")){
                            preparedStatement.setBlob(1,inputstream);
                            preparedStatement.setString(2,product_code);
                            
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
                 
       
       }
    
}
