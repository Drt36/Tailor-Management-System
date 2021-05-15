/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ValidateEmail {
    boolean status=false;
    
    //validate email exist or not in database
        public boolean validateUserEmail(String useremail) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_email = ? ")) {
            preparedStatement.setString(1,useremail);
            
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status;
    }
    
}
