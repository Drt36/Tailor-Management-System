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
public class SalaryCalculator {
    Float totalsalary=0f;
    //sum total paid salary
    public Float sumTotalSalary(String startdate,String enddate)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sum(amount) as salary_amount FROM `staffsalary` where salary_date BETWEEN"+"'"+startdate+"'"+"AND"+"'"+enddate+"'")) {
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           totalsalary= rs.getFloat("salary_amount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return totalsalary;
}
}
