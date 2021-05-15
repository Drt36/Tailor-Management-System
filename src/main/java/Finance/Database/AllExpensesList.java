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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dharm
 */
public class AllExpensesList {
    //all list
    public List < Expense > selectAllExpenses() {

        
            List < Expense > expenses = new ArrayList < > ();
            
            // Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from expenses ")
                    
                ) 
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String expense_id= rs.getString("expense_id");
                    String expense_title = rs.getString("expense_title");
                    Float expense_amount = rs.getFloat("expense_amount");
                    String expense_description= rs.getString("expense_description");
                    String expense_creator= rs.getString("expense_creator");
                    String expense_date= rs.getString("expense_date");
                    expenses.add(new Expense(expense_id,expense_title,expense_amount,expense_description,expense_creator,expense_date));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return expenses;
    }
    
    //all searched list
    public List < Expense > selectSearchedExpenses(String expense_idin) {

        
            List < Expense > expenses = new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from expenses where expense_id=?")
                    
                ) 
            {
                preparedStatement.setString(1,expense_idin);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String expense_id= rs.getString("expense_id");
                    String expense_title = rs.getString("expense_title");
                    Float expense_amount = rs.getFloat("expense_amount");
                    String expense_description= rs.getString("expense_description");
                    String expense_creator= rs.getString("expense_creator");
                    String expense_date= rs.getString("expense_date");
                    expenses.add(new Expense(expense_id,expense_title,expense_amount,expense_description,expense_creator,expense_date));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return expenses;
    }
    
    
}
