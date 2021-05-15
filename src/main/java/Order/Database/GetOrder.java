/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import Order.Model.Order;
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
public class GetOrder {
    //getting order for specific customer
    public List<Order> getOrders(String customer_emailin,String order_statusin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  customer_email= ? AND order_status=? ")) {
            preparedStatement.setString(1,customer_emailin);
             preparedStatement.setString(2,order_statusin);
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    
    //getting taken order for specific staff
    public List<Order> getOrdersForSpecificStaff(String staff_emailin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  taken_by=? ")) {
            preparedStatement.setString(1,staff_emailin);
            
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    
    //getting order for specific staff
    public List<Order> getOrdersForAllStaffs(String order_statusin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where order_status=? and taken_by=? ")) {
             preparedStatement.setString(1,order_statusin);
             preparedStatement.setString(2,"nottaken");
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    
    //getting order for bill details
    public List<Order> getOrdersForBillDetails(String bill_noin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  bill_no= ? ")) {
            preparedStatement.setString(1,bill_noin);
   
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    //getting all orders
    public List<Order> getAllOrders(String order_statusin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where order_status=? ")) {
             preparedStatement.setString(1,order_statusin);
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    //getting searched all orders
    public List<Order> getsearchedAllOrders(String order_statusin,String order_idin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where order_status=? and order_id=? ")) {
            preparedStatement.setString(1,order_statusin);
            preparedStatement.setString(2,order_idin);
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    //getting order for specific customer
    public List<Order> getOrdersToGenerateBill(String customer_emailin,String order_statusin,boolean is_billedin)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  customer_email= ? AND order_status=? AND is_billed=? ")) {
            preparedStatement.setString(1,customer_emailin);
            preparedStatement.setString(2,order_statusin);
            preparedStatement.setBoolean(3,is_billedin);
            
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
    //getting order for specific customer
    public List<Order> getOrdersForBill(String customer_emailin,String order_statusin,boolean is_billedin,String bill_id)throws ClassNotFoundException, SQLException {
      
            List <Order > order= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where  customer_email= ? AND order_status=? AND is_billed=? AND bill_no=? ")) {
            preparedStatement.setString(1,customer_emailin);
            preparedStatement.setString(2,order_statusin);
            preparedStatement.setBoolean(3,is_billedin);
            preparedStatement.setString(4,bill_id);
            
        
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String order_id=rs.getString("order_id");
                    String customer_email= rs.getString("customer_email");
                    String product_code= rs.getString("product_code");
                    String order_title=rs.getString("order_title");
                    String order_date=rs.getString("order_date");
                    String order_deliverydate=rs.getString("order_deliverydate");
                    String order_status=rs.getString("order_status");
                    Float order_amount= rs.getFloat("order_amount");
                    Float order_clothamount= rs.getFloat("order_clothamount");
                    Float order_discount= rs.getFloat("order_discount");
                    Float order_advance= rs.getFloat("order_advance");
                    Float order_totalamount=rs.getFloat("order_totalamount");
                    Float order_remainingamount=rs.getFloat("order_remainingamount");
                    boolean is_paymentclear=rs.getBoolean("is_paymentclear");
                    String order_description=rs.getString("order_description");
                    boolean is_billed=rs.getBoolean("is_billed");
                    String bill_no=rs.getString("bill_no"); 
                    String taken_by=rs.getString("taken_by");
                    order.add(new Order(order_id,customer_email,product_code,order_title,order_date,order_deliverydate,order_status,order_amount,order_clothamount,order_discount,order_advance,order_totalamount,order_remainingamount,is_paymentclear,order_description,is_billed,bill_no,taken_by));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return order;
    }
}
