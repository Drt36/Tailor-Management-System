/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Database;

import Customer.Model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class RegisterCustomer {
    public void addCustomer(Customer customer) throws ClassNotFoundException{
        
                       String INSERT_USERS_SQL = "INSERT INTO customers" +
                            "  (customer_username,customer_fullname,customer_email,customer_contact,customer_address,customer_dateofbirth,customer_gender) VALUES " +"(?,?,?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,customer.getCustomer_username());
                            preparedStatement.setString(2,customer.getCustomer_fullname());
                            preparedStatement.setString(3,customer.getCustomer_email());
                            preparedStatement.setString(4,customer.getCustomer_contact());
                            preparedStatement.setString(5,customer.getCustomer_address());
                            preparedStatement.setString(6,customer.getCustomer_dateofbirth());
                            preparedStatement.setString(7,customer.getCustomer_gender());
                            
                            
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
    
}
