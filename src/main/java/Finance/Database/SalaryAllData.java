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

/**
 *
 * @author dharm
 */
public class SalaryAllData {
    public Salary getAllDataOfSalary(String staff_email)throws ClassNotFoundException, SQLException {
          Salary salary=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from staffsalary where  staff_email= ? ")) {
            preparedStatement.setString(1,staff_email);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    salary=new Salary();
                    salary.setSalary_id(rs.getInt("salary_id"));
                    salary.setStaff_email(rs.getString("staff_email"));
                    salary.setSalary_date(rs.getString("salary_date"));
                    salary.setAmount(rs.getFloat("amount"));
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return salary;
    }
}
