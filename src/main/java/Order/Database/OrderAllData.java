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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class OrderAllData {
    
     public Order getAllDataOfOrder(String order_id)throws ClassNotFoundException, SQLException {
         Order order=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  order_id= ? ")) {
            preparedStatement.setString(1,order_id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    order=new Order();
                    order.setOrder_id(rs.getString("order_id"));
                    order.setCustomer_email(rs.getString("customer_email"));
                    order.setProduct_code(rs.getString("product_code"));
                    order.setOrder_title(rs.getString("order_title"));
                    order.setOrder_date(rs.getString("order_date"));
                    order.setOrder_deliverydate(rs.getString("order_deliverydate"));
                    order.setOrder_status(rs.getString("order_status"));
                    order.setOrder_amount(rs.getFloat("order_amount"));
                    order.setOrder_clothamount(rs.getFloat("order_clothamount"));
                    order.setOrder_discount(rs.getFloat("order_discount"));
                    order.setOrder_advance(rs.getFloat("order_advance"));
                    order.setOrder_totalamount(rs.getFloat("order_totalamount"));
                    order.setOrder_remainingamount(rs.getFloat("order_remainingamount"));
                    order.setIs_paymentclear(rs.getBoolean("is_paymentclear"));
                    order.setOrder_description(rs.getString("order_description"));
                    order.setIs_billed(rs.getBoolean("is_billed"));
                    order.setBill_no(rs.getString("bill_no"));
                    
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    
}
