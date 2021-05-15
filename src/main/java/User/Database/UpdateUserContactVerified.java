/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UpdateUserContactVerified {
    //change user contact status
    public void updateUserContactVerified(String user_email,boolean status) throws ClassNotFoundException, SQLException {
 
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update users set user_contactverified = ? where user_email= ? ")) {
            preparedStatement.setBoolean(1,status);
            preparedStatement.setString(2,user_email);
          
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
