
package Customer.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class CustomerCounter {
    int total_customer=0;
      //count total customer
    public int countTotalCustomers()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(customer_id) AS total_customer from customers ")) {
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           total_customer = rs.getInt("total_customer");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_customer;
    }
    
}
