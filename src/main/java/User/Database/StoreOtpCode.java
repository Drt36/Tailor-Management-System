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
public class StoreOtpCode {
    
    public void saveOtpCode(String user_email,String Otpcode) throws ClassNotFoundException{
           int result = 0;    
                       String INSERT_USERS_SQL = "INSERT INTO codevalidate" +
                            "  (user_email,Otpcode) VALUES " +"(?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,user_email);
                            preparedStatement.setString(2,Otpcode);
                            
                            // Step 3: update query
                            result = preparedStatement.executeUpdate();

                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
       
       }
    
}
