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
public class StaffTaskCounter {
    int todays_task=0;
    int total_task=0;
    //count todays task
    public int countTodaysTask(String date,String staff_email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(income_id) AS todays_tasks from staffincome where income_date=? and staff_email=? ")) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, staff_email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           todays_task= rs.getInt("todays_tasks");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return todays_task;
    }
    
    //count lifetime tasks
    public int countLifetimeTask(String staff_email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(income_id) AS lifetime_tasks from staffincome where staff_email=? ")) {
            preparedStatement.setString(1, staff_email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_task= rs.getInt("lifetime_tasks");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_task;
    }
    
}
