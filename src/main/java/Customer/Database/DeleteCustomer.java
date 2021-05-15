/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class DeleteCustomer {
    //Deleting customer
    public void deleteCustomer(String customer_email) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from customers where customer_email= ?  ")) {
            preparedStatement.setString(1,customer_email);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
    }
    
}
