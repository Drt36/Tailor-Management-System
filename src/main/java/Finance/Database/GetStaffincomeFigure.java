/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Database;

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
public class GetStaffincomeFigure {
    //getting staffincome figure
    public List<Map<Object, Object>> getStaffIncomeFigure(String staff_email,String startdate,String enddate)throws ClassNotFoundException, SQLException {
            Map<Object,Object> map = null;
            List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
            
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");
            Statement statement = connection.createStatement();
           
            
            ResultSet rs =statement.executeQuery("SELECT sum(amount) as totalamount,income_date FROM `staffincome` where staff_email="+"'"+staff_email+"'"+" and income_date BETWEEN"+"'"+startdate+"'"+"AND"+"'"+enddate+"'"+"group by income_date");
              while (rs.next()) {
                    Date date=rs.getDate("income_date");
                    long xVal=date.getTime();
                    Float yVal=rs.getFloat("totalamount");
                    map = new HashMap<Object,Object>(); 
                    map.put("x",xVal); 
                    map.put("y",yVal);
                    list.add(map);
 
                }


        return list;
    }
    
}
