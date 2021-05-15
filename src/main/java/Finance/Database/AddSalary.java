/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import Finance.Model.Expense;
import Finance.Model.Salary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddSalary {
    public void addSalry(Salary salary) throws ClassNotFoundException{
        
                       String INSERT_USERS_SQL = "INSERT INTO staffsalary" +
                            "  (staff_email,salary_date,amount) VALUES " +"(?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,salary.getStaff_email());
                            preparedStatement.setString(2,salary.getSalary_date());
                            preparedStatement.setFloat(3,salary.getAmount());
        
                            //Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
}
