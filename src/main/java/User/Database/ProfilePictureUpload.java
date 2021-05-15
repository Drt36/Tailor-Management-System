/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ProfilePictureUpload {
    String user_email;
    InputStream inputstream;
    public void saveUserProfile(String user_email,InputStream inputstream) throws ClassNotFoundException{
        this.user_email=user_email;
        this.inputstream=inputstream;
           int result = 0;
                 
                    
                       String INSERT_SQL = "INSERT INTO profilepictures" +
                            "(User_email,photo) VALUES " +"(?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)){
                            preparedStatement.setString(1,user_email);
                            preparedStatement.setBlob(2,inputstream);
   
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
                 
       
       }
     public void updateUserProfile(String user_email,InputStream inputstream) throws ClassNotFoundException{
        this.user_email=user_email;
        this.inputstream=inputstream;
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement("Update profilepictures set photo= ? where User_email= ?")){
                            preparedStatement.setBlob(1,inputstream);
                            preparedStatement.setString(2,user_email);
                            
                            preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
                 
       
       }
    
}
