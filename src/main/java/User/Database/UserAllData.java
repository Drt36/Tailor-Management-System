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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UserAllData {
    
    public User getAllDataOfUser(String user_email)throws ClassNotFoundException, SQLException {
         User user=null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where  user_email= ? ")) {
            preparedStatement.setString(1,user_email);
            
            ResultSet rs = preparedStatement.executeQuery();
             while (rs.next()) {
                   user=new User(); 
                    user.setUsername(rs.getString("username"));
                    user.setUser_fullname(rs.getString("user_fullname"));  
                    user.setUser_email(rs.getString("user_email"));  
                    user.setUser_contact(rs.getString("user_contact"));  
                    user.setUser_address(rs.getString("user_address"));  
                    user.setUser_dateofbirth(rs.getString("user_dateofbirth")); 
                    user.setUser_gender(rs.getString("user_gender"));
                    user.setUser_role(rs.getString("user_role"));    
                    user.setUser_contactverified(rs.getBoolean("user_contactverified"));
                    user.setIs_blocked(rs.getBoolean("is_blocked"));
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return user;
    }
    
}
