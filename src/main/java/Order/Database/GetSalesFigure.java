package Order.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author dharm
 */
public class GetSalesFigure {
    //getting sales figure
    public List<Map<Object, Object>> getSalesFigure(String startdate,String enddate)throws ClassNotFoundException, SQLException {
            Map<Object,Object> map = null;
            List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
            
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");
            Statement statement = connection.createStatement();
           
            
            ResultSet rs =statement.executeQuery("SELECT sum(order_totalamount) as order_totalamount,order_date FROM `orders` where order_date BETWEEN"+"'"+startdate+"'"+"AND"+"'"+enddate+"'"+"group by order_date");
              while (rs.next()) {
                    Date date=rs.getDate("order_date");
                    long xVal=date.getTime();
                    Float yVal=rs.getFloat("order_totalamount");
                    map = new HashMap<Object,Object>(); 
                    map.put("x",xVal); 
                    map.put("y",yVal);
                    list.add(map);
 
                }


        return list;
    }
}
