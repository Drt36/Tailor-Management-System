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
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class AddDesign {
    public void addDesign(Design design) throws ClassNotFoundException{
        
        String INSERT_USERS_SQL = "INSERT INTO chooseddesign" +
         "  (order_id,design_url) VALUES " +"(?,?);";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1,design.getOrder_id());
            preparedStatement.setString(2,design.getDesign_url());

            // Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        }
  
    }
    
}
