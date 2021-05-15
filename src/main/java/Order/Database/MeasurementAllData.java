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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class MeasurementAllData {
    public Measurement getAllDataOfMeasurement(String order_id)throws ClassNotFoundException, SQLException {
         Measurement measurement=null;

          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from measurments where  order_id= ? ")) {
            preparedStatement.setString(1,order_id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    measurement=new Measurement();
                    measurement.setMeasurment_id(rs.getInt("measurment_id"));
                    measurement.setOrder_id(rs.getString("order_id"));
                    measurement.setMeasurment_title(rs.getString("measurment_title"));
                    measurement.setLength(rs.getFloat("length"));
                    measurement.setWaist(rs.getFloat("waist"));
                    measurement.setShoulder(rs.getFloat("shoulder"));
                    measurement.setLength_of_hand(rs.getFloat("length_of_hand"));
                    measurement.setNeck(rs.getFloat("neck"));
                    measurement.setChest(rs.getFloat("chest"));
                    measurement.setThigh(rs.getFloat("thigh"));
                    measurement.setInner_lenght(rs.getFloat("inner_length"));
                    measurement.setHip(rs.getFloat("hip"));
                    
                    
                    
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return measurement;
    }
    
}
