/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class GetProfilePicture {
     boolean status=false;
    public Blob getProfilePicture(String user_email) throws SQLException{
        Blob blob = null;
    try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from profilepictures where user_email= ?")
                 
                ) 
            {
                preparedStatement.setString(1,user_email);   
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                   blob = rs.getBlob("photo");
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return blob;
    
    }
    public boolean checkProfilePicture(String user_email) throws SQLException{
       
    try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from profilepictures where user_email= ?")
                 
                ) 
            {
                preparedStatement.setString(1,user_email);   
                ResultSet rs = preparedStatement.executeQuery();
                status = rs.next();

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return status;
    
    }
    
}
