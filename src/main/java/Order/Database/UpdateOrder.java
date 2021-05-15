/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UpdateOrder {
    //update order details
    public void updateOrderDetails(String order_title,String order_deliverydate,Float order_clothamount,Float order_discount,Float order_advance,Float order_totalamount,Float order_remainingamount,String order_description,boolean is_paymentclear,String order_id) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update orders set order_title=?,order_deliverydate=?,order_clothamount=?,order_discount=?,order_advance=?,order_totalamount=?,order_remainingamount=?,order_description=?,is_paymentclear=? where order_id= ?")) {
            preparedStatement.setString(1,order_title);
            preparedStatement.setString(2,order_deliverydate);
            preparedStatement.setFloat(3,order_clothamount);
            preparedStatement.setFloat(4,order_discount);
            preparedStatement.setFloat(5,order_advance);
            preparedStatement.setFloat(6,order_totalamount);
            preparedStatement.setFloat(7,order_remainingamount);
            preparedStatement.setString(8,order_description);
            preparedStatement.setBoolean(9,is_paymentclear);
            preparedStatement.setString(10,order_id);
 
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
