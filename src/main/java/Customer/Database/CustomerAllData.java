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

/**
 *
 * @author dharm
 */
public class CustomerAllData {
    //getting all the data of customer
    public Customer getAllDataOfCustomer(String customer_email)throws ClassNotFoundException, SQLException {
         Customer customer=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where  customer_email= ? ")) {
            preparedStatement.setString(1,customer_email);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    customer=new Customer(); 
                    customer.setCustomer_username(rs.getString("customer_username"));
                    customer.setCustomer_fullname(rs.getString("customer_fullname"));  
                    customer.setCustomer_email(rs.getString("customer_email"));  
                    customer.setCustomer_contact(rs.getString("customer_contact"));  
                    customer.setCustomer_address(rs.getString("customer_address"));  
                    customer.setCustomer_dateofbirth(rs.getString("customer_dateofbirth")); 
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return customer;
    }
    
}
