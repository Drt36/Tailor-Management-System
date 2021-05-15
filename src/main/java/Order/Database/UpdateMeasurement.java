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
public class UpdateMeasurement {
     //update measurment details
    public void updateMeasurmentDetails(String measurement_title,Float length,Float waist,Float shoulder,Float length_of_hand,Float neck,Float chest,Float thigh,Float inner_length,Float hip,String order_id) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update measurments set measurment_title=?,length=?,waist=?,shoulder=?,length_of_hand=?,neck=?,chest=?,thigh=?,inner_length=?,hip=? where order_id= ?")) {
            preparedStatement.setString(1,measurement_title);
            preparedStatement.setFloat(2,length);
            preparedStatement.setFloat(3,waist);
            preparedStatement.setFloat(4,shoulder);
            preparedStatement.setFloat(5,length_of_hand);
            preparedStatement.setFloat(6,neck);
            preparedStatement.setFloat(7,chest);
            preparedStatement.setFloat(8,thigh);
            preparedStatement.setFloat(9,inner_length);
            preparedStatement.setFloat(10,hip);
            preparedStatement.setString(11,order_id);
           
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
