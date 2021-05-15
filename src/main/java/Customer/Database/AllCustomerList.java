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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dharm
 */
public class AllCustomerList {
    //all list
    public List < Customer > selectAllCustomers() {

        
            List < Customer > customers = new ArrayList < > ();
            
            // Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from customers ")
                    
                ) 
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String customer_username= rs.getString("customer_username");
                    String customer_fullname = rs.getString("customer_fullname");
                    String customer_email = rs.getString("customer_email");
                    String customer_contact = rs.getString("customer_contact");
                    String customer_address=rs.getString("customer_address");
                    String customer_dateofbirth= rs.getString("customer_dateofbirth");
                    String customer_gender= rs.getString("customer_gender");
                    
                    customers.add(new Customer(customer_username,customer_fullname,customer_email,customer_contact,customer_address,customer_dateofbirth,customer_gender));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return customers;
    }
    
    
    //searched list 
    public List < Customer > searchAllCustomers(String customeremailor_usernameor_contact) {

        
            List < Customer > customers = new ArrayList < > ();
            
            // Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where  customer_email= ? OR customer_username=? OR customer_contact=? ")){
                preparedStatement.setString(1,customeremailor_usernameor_contact);  
                preparedStatement.setString(2,customeremailor_usernameor_contact);
                preparedStatement.setString(3,customeremailor_usernameor_contact);
                
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String customer_username= rs.getString("customer_username");
                    String customer_fullname = rs.getString("customer_fullname");
                    String customer_email = rs.getString("customer_email");
                    String customer_contact = rs.getString("customer_contact");
                    String customer_address=rs.getString("customer_address");
                    String customer_dateofbirth= rs.getString("customer_dateofbirth");
                    String customer_gender= rs.getString("customer_gender");
                    
                    customers.add(new Customer(customer_username,customer_fullname,customer_email,customer_contact,customer_address,customer_dateofbirth,customer_gender));
                }
            }
            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return customers;
    }
    
}
