/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import Finance.Model.Salary;
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
public class StaffSalaryList {
    public List < Salary > getStaffSalaryList(String staff_emailin) {

            List < Salary > salary= new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");
                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from staffsalary where staff_email=?")   
                ) 
            {
                preparedStatement.setString(1,staff_emailin);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    int salary_id= rs.getInt("salary_id");
                    String staff_email=rs.getString("staff_email");
                    String salary_date=rs.getString("salary_date");
                    Float  amount=rs.getFloat("amount");
                    salary.add(new Salary(salary_id,staff_email,salary_date,amount));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return salary;
    }
}
