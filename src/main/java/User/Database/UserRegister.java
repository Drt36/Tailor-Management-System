/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;

import User.Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UserRegister {
    public void saveUser(User user) throws ClassNotFoundException{
           int result = 0;
                 
                    
                       String INSERT_USERS_SQL = "INSERT INTO users" +
                            "  (username,user_fullname,user_email,user_contact,user_address,user_dateofbirth,user_gender,user_role,user_password,user_contactverified) VALUES " +"(?,?,?,?,?,?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,user.getUsername());
                            preparedStatement.setString(2,user.getUser_fullname());
                            preparedStatement.setString(3,user.getUser_email());
                            preparedStatement.setString(4,user.getUser_contact());
                            preparedStatement.setString(5,user.getUser_address());
                            preparedStatement.setString(6,user.getUser_dateofbirth());
                            preparedStatement.setString(7,user.getUser_gender());
                            preparedStatement.setString(8,user.getUser_role());
                            preparedStatement.setString(9,user.getUser_password());
                            preparedStatement.setBoolean(10,user.isUser_contactverified());
                            
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
                   System.out.println(result);
       
       }
    
}
