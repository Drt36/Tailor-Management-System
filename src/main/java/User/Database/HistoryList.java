/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;

import User.Model.History;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dharm
 */
public class HistoryList {
    //getting history
    public List<History> getHistory(String user_email)throws ClassNotFoundException, SQLException {
      
            List < History > history= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from history where  user_email= ? ")) {
            preparedStatement.setString(1,user_email);
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String useremail= rs.getString("user_email");
                    String task= rs.getString("task");
                    String datetimes = rs.getString("datetimes");
                    history.add(new History(useremail,task,datetimes));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return history;
    }
    
}
