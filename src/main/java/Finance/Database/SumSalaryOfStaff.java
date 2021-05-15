/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class SumSalaryOfStaff {
    float paidsalary=0f;
    public float sumTotalPaidSalaryOfStaff(String staff_email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(amount) AS paidsalary from staffsalary where staff_email=?")) {
            preparedStatement.setString(1,staff_email);  
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            paidsalary= rs.getFloat("paidsalary");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return paidsalary;
    }
    //getting todays paid salary
    float todayspaidsalary=0f;
    public float sumTodaysPaidSalaryOfStaff(String staff_email,String date)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(amount) AS paidsalary from staffsalary where staff_email=? and salary_date=? ")) {
            preparedStatement.setString(1,staff_email);  
            preparedStatement.setString(2,date);  
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            paidsalary= rs.getFloat("paidsalary");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return paidsalary;
    }
    
}
