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
public class ClearDue {
    //clear due amount
    public void clearDue(Float order_remainingamount,boolean is_paymentclear,String order_id) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update orders set order_remainingamount=?,is_paymentclear=? where order_id= ?")) {
            preparedStatement.setFloat(1,order_remainingamount);
            preparedStatement.setBoolean(2,is_paymentclear);
            preparedStatement.setString(3,order_id);
 
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
    
}
}