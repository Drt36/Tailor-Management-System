
package Finance.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ExpenseCalculator {
    float todays_expense=0f;
    float total_expense=0f;
    //sum todays expense
    public Float sumTodaysExpense(String date)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(expense_amount) AS todays_expense from expenses where expense_date=? ")) {
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           todays_expense= rs.getFloat("todays_expense");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return todays_expense;
    }
    
    //sum total Expense
    public Float sumTotalExpense(String startdate,String enddate)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sum(expense_amount) as expense_amount FROM `expenses` where expense_date BETWEEN"+"'"+startdate+"'"+"AND"+"'"+enddate+"'")) {
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            total_expense= rs.getFloat("expense_amount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return total_expense;
}
}
