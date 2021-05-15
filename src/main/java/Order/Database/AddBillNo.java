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
public class AddBillNo{
    //update bill no and is_billed
    public void addBillNo(String order_id,String bill_no,boolean is_billed) throws ClassNotFoundException, SQLException {
 
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update orders set bill_no=?,is_billed=? where order_id= ? ")) {
            preparedStatement.setString(1,bill_no);
            preparedStatement.setBoolean(2,is_billed);
            preparedStatement.setString(3,order_id);
          
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
    
}
