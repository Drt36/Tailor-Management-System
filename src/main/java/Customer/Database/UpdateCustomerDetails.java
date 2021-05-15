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
public class UpdateCustomerDetails {
    
    //updating the customer details
     public void updateUserDetails(String customer_email,String customer_fullname,String customer_contact,String customer_address,String customer_dateofbirth,String customer_gender) throws ClassNotFoundException, SQLException {
 
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update customers set customer_fullname = ?,customer_contact=?,customer_address=?,customer_dateofbirth=?,customer_gender=? where customer_email= ? ")) {
            preparedStatement.setString(1,customer_fullname);
            preparedStatement.setString(2,customer_contact);
            preparedStatement.setString(3,customer_address);
            preparedStatement.setString(4,customer_dateofbirth);
            preparedStatement.setString(5,customer_gender);
            preparedStatement.setString(6,customer_email);
            
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
