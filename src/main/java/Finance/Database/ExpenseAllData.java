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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ExpenseAllData {
    public Expense getAllDataOfExpense(String expense_id)throws ClassNotFoundException, SQLException {
          Expense expense=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from expenses where  expense_id= ? ")) {
            preparedStatement.setString(1,expense_id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    expense=new Expense();
                    expense.setExpense_id(rs.getString("expense_id"));
                    expense.setExpense_title(rs.getString("expense_title"));
                    expense.setExpense_amount(rs.getFloat("expense_amount"));
                    expense.setExpense_creator(rs.getString("expense_creator"));
                    expense.setExpense_description(rs.getString("expense_description"));
                    expense.setExpense_date(rs.getString("expense_date"));
                    
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return expense;
    }
    
}
