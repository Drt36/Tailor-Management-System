
package Order.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class OrderCounter {
    int todays_orders=0;
      //count total orders
    public int countTodaysOrder(String date)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(order_id) AS todays_orders from orders where order_date=? ")) {
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           todays_orders= rs.getInt("todays_orders");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return todays_orders;
    }
    
}
