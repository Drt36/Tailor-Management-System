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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dharm
 */
public class StaffIncomeList {
    public List < Income > getStaffIncomeList(String staff_emailin) {

        
            List < Income > incomes = new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");
                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from staffincome where staff_email=?")   
                ) 
            {
                preparedStatement.setString(1,staff_emailin);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    int income_id= rs.getInt("income_id");
                    String staff_email=rs.getString("staff_email");
                    String order_id=rs.getString("order_id");
                    String product_code=rs.getString("product_code");
                    Float  amount=rs.getFloat("amount");
                    String income_date=rs.getString("income_date");
                    incomes.add(new Income(income_id,staff_email,order_id,product_code,amount,income_date));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return incomes;
    }
}
