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
public class StoreHistory {
    //store history
    public void storeHistory(String user_email, String task,String datetimes) throws ClassNotFoundException{

                       String INSERT_USERS_SQL = "INSERT INTO history" +
                            "  (user_email,task,datetimes) VALUES " +"(?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,user_email);
                            preparedStatement.setString(2,task);
                            preparedStatement.setString(3,datetimes);
     
                            // Step 3: Execute the query or update query0
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
       
       }
    
}
