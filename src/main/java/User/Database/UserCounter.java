package User.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class UserCounter {
    int total_activeuser=0;
    int total_blockeduser=0;
     int total_staffs=0;
    //count total active user
    public int countTotalActiveUsers()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(user_id) AS total_user from users where is_blocked=false ")) {
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_activeuser= rs.getInt("total_user");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_activeuser;
    }
    
    //count total blocked users
    public int countTotalBlockedUsers()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(user_id) AS total_user from users where is_blocked=true ")) {
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_blockeduser= rs.getInt("total_user");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_blockeduser;
    }
    
     //count total staffs
    public int countTotalStaffs()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(user_id) AS total_staffs from users where user_role='Staff' ")) {
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_staffs= rs.getInt("total_staffs");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_staffs;
    }
    
}
