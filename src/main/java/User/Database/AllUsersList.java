/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Database;
import User.Model.User;
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
public class AllUsersList {
    
    //list all users
        public List < User > selectAllUsers() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users ")
                    
                ) 
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String username= rs.getString("username");
                    String user_fullname = rs.getString("user_fullname");
                    String user_email = rs.getString("user_email");
                    String user_contact = rs.getString("user_contact");
                    String user_address=rs.getString("user_address");
                    String user_dateofbirth= rs.getString("user_dateofbirth");
                    String user_gender= rs.getString("user_gender");
                    String user_role= rs.getString("user_role");
                    boolean user_contactverified=rs.getBoolean("user_contactverified");
                    boolean is_blocked=rs.getBoolean("is_blocked");
                    users.add(new User(username,user_fullname,user_email, user_contact,user_address,user_dateofbirth,user_gender,user_role,user_contactverified,is_blocked));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return users;
    }
    
    //list all blocked users
    public List < User > selectAllBlockedUsers() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users where is_blocked=true ")
                    
                ) 
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String username= rs.getString("username");
                    String user_fullname = rs.getString("user_fullname");
                    String user_email = rs.getString("user_email");
                    String user_contact = rs.getString("user_contact");
                    String user_address=rs.getString("user_address");
                    String user_dateofbirth= rs.getString("user_dateofbirth");
                    String user_gender= rs.getString("user_gender");
                    String user_role= rs.getString("user_role");
                    boolean user_contactverified=rs.getBoolean("user_contactverified");
                    boolean is_blocked=rs.getBoolean("is_blocked");
                    users.add(new User(username,user_fullname,user_email, user_contact,user_address,user_dateofbirth,user_gender,user_role,user_contactverified,is_blocked));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return users;
    }
    
    //list all Unblocked users
        public List < User > selectAllUnblockedUsers() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users where is_blocked=false ")
                    
                ) 
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String username= rs.getString("username");
                    String user_fullname = rs.getString("user_fullname");
                    String user_email = rs.getString("user_email");
                    String user_contact = rs.getString("user_contact");
                    String user_address=rs.getString("user_address");
                    String user_dateofbirth= rs.getString("user_dateofbirth");
                    String user_gender= rs.getString("user_gender");
                    String user_role= rs.getString("user_role");
                    boolean user_contactverified=rs.getBoolean("user_contactverified");
                    boolean is_blocked=rs.getBoolean("is_blocked");
                    users.add(new User(username,user_fullname,user_email, user_contact,user_address,user_dateofbirth,user_gender,user_role,user_contactverified,is_blocked));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return users;
    }
    //list all staffs 
        public List < User > selectAllStaffs() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users where user_role='Staff' ")
                    
                ) 
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String username= rs.getString("username");
                    String user_fullname = rs.getString("user_fullname");
                    String user_email = rs.getString("user_email");
                    String user_contact = rs.getString("user_contact");
                    String user_address=rs.getString("user_address");
                    String user_dateofbirth= rs.getString("user_dateofbirth");
                    String user_gender= rs.getString("user_gender");
                    String user_role= rs.getString("user_role");
                    boolean user_contactverified=rs.getBoolean("user_contactverified");
                    boolean is_blocked=rs.getBoolean("is_blocked");
                    users.add(new User(username,user_fullname,user_email, user_contact,user_address,user_dateofbirth,user_gender,user_role,user_contactverified,is_blocked));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return users;
    }
    
}
