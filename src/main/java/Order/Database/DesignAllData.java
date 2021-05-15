/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import Order.Model.Design;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class DesignAllData {
    public Design getAllDataOfDesign(String order_id)throws ClassNotFoundException, SQLException {
         Design design=null;

          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from chooseddesign where  order_id= ? ")) {
            preparedStatement.setString(1,order_id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    design=new Design();
                    design.setDesign_id(rs.getInt("design_id"));
                    design.setOrder_id(rs.getString("order_id"));
                    design.setDesign_url(rs.getString("design_url"));
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return design;
    }
    
}
