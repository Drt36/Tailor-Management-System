/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UpdateExpense {
    //update the product details
     public void updateExpenseDetails(String expense_title,Float expense_amount,String expense_description,String expense_creator,String expense_id) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update expenses set expense_title= ?,expense_amount=?,expense_description=?,expense_creator=? where expense_id=?")) {
            preparedStatement.setString(1,expense_title);
            preparedStatement.setFloat(2,expense_amount);
            preparedStatement.setString(3,expense_description);
            preparedStatement.setString(4, expense_creator);
             preparedStatement.setString(5, expense_id);
            
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
