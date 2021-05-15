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
public class SumTotalIncome {
    float income=0f;
    float today_income=0f;
    public float sumTotalIncomeOfStaff(String staff_email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(amount) AS salary from staffincome where staff_email=?")     
            ) 
            {
            preparedStatement.setString(1,staff_email);  
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            income= rs.getFloat("salary");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return income;
    }
    
    //getting todays income
    public float sumTodaysIncomeOfStaff(String staff_email,String date)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(amount) AS salary from staffincome where staff_email=? and income_date=? ")     
            ) 
            {
            preparedStatement.setString(1,staff_email);  
            preparedStatement.setString(2,date);  
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            income= rs.getFloat("salary");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return income;
    }
}
