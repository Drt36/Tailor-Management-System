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
public class ValidateOtpCode {
    boolean status=false;
    //validate  entered code and database code
       public boolean validateOtpCode(String user_email,String Otpcode) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from codevalidate where user_email = ? and Otpcode= ? ")) {
            preparedStatement.setString(1,user_email);
            preparedStatement.setString(2,Otpcode);
            ResultSet rs = preparedStatement.executeQuery(); 
            status = rs.next();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return status;
    }
    
}
