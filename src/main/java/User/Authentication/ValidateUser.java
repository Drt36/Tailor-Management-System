/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Authentication;

import Password.Encryption.Md5Hashing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ValidateUser {
    
    Md5Hashing md5hash=new Md5Hashing();
    boolean status=false;
    
     //validate email and password for login  to give access in system
    public boolean validateUserEmailPassword(String email,String password) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_email = ? and user_password = ? ")) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,md5hash.getMd5(password));
            ResultSet rs = preparedStatement.executeQuery(); 
            status = rs.next();
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status;
    }
}
