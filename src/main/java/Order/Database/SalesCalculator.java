
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
public class SalesCalculator {
    float todays_sales=0f;
    float total_sales=0f;
    //sum total sales
    public Float sumTodaysSales(String date)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(order_totalamount) AS todays_sales from orders where order_date=? ")) {
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           todays_sales= rs.getFloat("todays_sales");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return todays_sales;
    }
    
    //sum total sales
    public Float sumTotalSales(String startdate,String enddate)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sum(order_totalamount) as order_totalamount FROM `orders` where order_date BETWEEN"+"'"+startdate+"'"+"AND"+"'"+enddate+"'")) {
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_sales= rs.getFloat("order_totalamount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_sales;
    }
    
}
