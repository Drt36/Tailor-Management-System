/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import Order.Model.Measurement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddMeasurement {
    public void addMeasurement(Measurement measurement) throws ClassNotFoundException{
        
    String INSERT_USERS_SQL = "INSERT INTO measurments" +
     "  (order_id,measurment_title,length,waist,shoulder,length_of_hand,neck,chest,thigh,inner_length,hip) VALUES " +"(?,?,?,?,?,?,?,?,?,?,?);";

    Class.forName("com.mysql.cj.jdbc.Driver");

    try(
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

        //Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,measurement.getOrder_id());
                            preparedStatement.setString(2,measurement.getMeasurment_title());
                            preparedStatement.setFloat(3,measurement.getLength());
                            preparedStatement.setFloat(4,measurement.getWaist());
                            preparedStatement.setFloat(5,measurement.getShoulder());
                            preparedStatement.setFloat(6,measurement.getLength_of_hand());
                            preparedStatement.setFloat(7,measurement.getNeck());
                            preparedStatement.setFloat(8,measurement.getChest());
                            preparedStatement.setFloat(9,measurement.getThigh());
                            preparedStatement.setFloat(10,measurement.getInner_lenght());
                            preparedStatement.setFloat(11,measurement.getHip());

                            // Execute the query or update query
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
  
       }
}
