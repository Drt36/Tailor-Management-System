/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

import Finance.Model.Income;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class IncomeAllData {
    public Income getAllDataOfIncome(String staff_email)throws ClassNotFoundException, SQLException {
          Income income=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from staffincome where  staff_email= ? ")) {
            preparedStatement.setString(1,staff_email);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    income=new Income();
                    income.setIncome_id(rs.getInt("income_id"));
                    income.setStaff_email(rs.getString("staff_email"));
                    income.setOrder_id(rs.getString("order_id"));
                    income.setProduct_code(rs.getString("product_code"));
                    income.setAmount(rs.getFloat("amount"));
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return income;
    }
    
}
