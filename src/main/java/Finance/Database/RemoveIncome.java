/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class RemoveIncome {
     public void removestaffincome(String order_id) throws ClassNotFoundException, SQLException {
 
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from staffincome where order_id= ?  ")) {
            preparedStatement.setString(1,order_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
    }
    
}
