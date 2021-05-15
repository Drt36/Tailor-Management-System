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
public class UpdateUserDetails {
    //update the user details
     public void updateUserDetails(String user_email,String user_fullname,String user_address,String user_dateofbirth,String user_gender,String user_role) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update users set user_fullname = ?,user_address=?,user_dateofbirth=?,user_gender=?,user_role=? where user_email= ? ")) {
            preparedStatement.setString(1,user_fullname);
            preparedStatement.setString(2,user_address);
            preparedStatement.setString(3,user_dateofbirth);
            preparedStatement.setString(4,user_gender);
            preparedStatement.setString(5,user_role);
            preparedStatement.setString(6,user_email);
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
