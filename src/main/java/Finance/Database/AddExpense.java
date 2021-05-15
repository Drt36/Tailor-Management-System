/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import Finance.Model.Expense;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddExpense {
    public void addExpense(Expense expense) throws ClassNotFoundException{
        
                       String INSERT_USERS_SQL = "INSERT INTO expenses" +
                            "  (expense_id,expense_title,expense_amount,expense_description,expense_creator,expense_date) VALUES " +"(?,?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,expense.getExpense_id());
                            preparedStatement.setString(2,expense.getExpense_title());
                            preparedStatement.setFloat(3,expense.getExpense_amount());
                            preparedStatement.setString(4,expense.getExpense_description());
                            preparedStatement.setString(5,expense.getExpense_creator());
                            preparedStatement.setString(6,expense.getExpense_date());
                           
                      
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
    
}
