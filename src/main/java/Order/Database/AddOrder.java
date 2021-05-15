/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import Order.Model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddOrder {
    public void addOrder(Order order) throws ClassNotFoundException{
        
    String INSERT_USERS_SQL = "INSERT INTO orders" +
     "  (customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,order_id ) VALUES " +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    Class.forName("com.mysql.cj.jdbc.Driver");

    try(
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

        //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,order.getCustomer_email());
                            preparedStatement.setString(2,order.getProduct_code());
                            preparedStatement.setString(3,order.getOrder_title());
                            preparedStatement.setString(4,order.getOrder_date());
                            preparedStatement.setString(5,order.getOrder_deliverydate());
                            preparedStatement.setString(6,order.getOrder_status());
                            preparedStatement.setFloat(7,order.getOrder_amount());
                            preparedStatement.setFloat(8,order.getOrder_clothamount());
                            preparedStatement.setFloat(9,order.getOrder_discount());
                            preparedStatement.setFloat(10,order.getOrder_advance());
                            preparedStatement.setFloat(11,order.getOrder_totalamount());
                            preparedStatement.setFloat(12,order.getOrder_remainingamount());
                            preparedStatement.setBoolean(13,order.isIs_paymentclear());
                            preparedStatement.setString(14,order.getOrder_description());
                            preparedStatement.setString(15,order.getOrder_id());
                           
                      
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
    
}
