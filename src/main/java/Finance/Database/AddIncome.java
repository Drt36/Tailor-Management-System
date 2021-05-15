/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import Finance.Model.Expense;
import Finance.Model.Income;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddIncome {
    public void addIncome(Income income) throws ClassNotFoundException{
        
                       String INSERT_USERS_SQL = "INSERT INTO staffincome" +
                            "  (staff_email,order_id,product_code,amount,income_date) VALUES " +"(?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,income.getStaff_email());
                            preparedStatement.setString(2,income.getOrder_id());
                            preparedStatement.setString(3,income.getProduct_code());
                            preparedStatement.setFloat(4,income.getAmount());
                            preparedStatement.setString(5,income.getIncome_date());
                           
                      
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
}
