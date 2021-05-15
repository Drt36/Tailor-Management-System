/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class SaveBill {
    public  void saveBill(String bill_no,String bill_date,float bill_actualamount,float bill_advanced,float bill_dueamount) throws ClassNotFoundException{
     String INSERT_USERS_SQL = "INSERT INTO bills" +
                            "  (bill_no,bill_date,bill_actualamount,bill_advanced,bill_dueamount) VALUES " +"(?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,bill_no);
                            preparedStatement.setString(2,bill_date);
                            preparedStatement.setFloat(3,bill_actualamount);
                            preparedStatement.setFloat(4,bill_advanced);
                            preparedStatement.setFloat(5,bill_dueamount);
                       
                            // Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
    
    
    }
    

