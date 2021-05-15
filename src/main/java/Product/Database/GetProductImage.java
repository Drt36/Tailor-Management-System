/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Database;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class GetProductImage {
    public Blob getProductImage(String product_code) throws SQLException{
        Blob blob = null;
    try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from productimages where product_code= ?")
                 
                ) 
            {
                preparedStatement.setString(1,product_code);   
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                   blob = rs.getBlob("product_photo");
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return blob;
    
    }
    
}
