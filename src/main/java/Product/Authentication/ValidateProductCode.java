/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ValidateProductCode {
    
    boolean status=false;
    
    //validate product code exist or not in database
        public boolean validateProductCode(String product_code) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where product_code = ? ")) {
            preparedStatement.setString(1,product_code);
            
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status;
    }
    
}
