/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Database;

import Order.Model.Bill;
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
public class AllBillsList {
    //all bill list
    public List < Bill > selectAllBills() {

        
            List < Bill > bill = new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from bills ")
                    
                ) 
            {
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    int bill_id=rs.getInt("bill_id");
                    String bill_no= rs.getString("bill_no");
                    String bill_date = rs.getString("bill_date");
                    Float bill_actualamount= rs.getFloat("bill_actualamount");
                    Float bill_advanced= rs.getFloat("bill_advanced");
                    Float bill_dueamount= rs.getFloat("bill_dueamount");
                 
                    
                    bill.add(new Bill(bill_id,bill_no,bill_date,bill_actualamount,bill_advanced,bill_dueamount));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return bill;
    }
    
    //all searched bill list
    public List < Bill > selectSearchedBills(String bill_noin) {

        
            List < Bill > bill = new ArrayList < > ();
            
            //Establishing a Connection
            try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

                //Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from bills where bill_no=? ")  )    
            {
                 preparedStatement.setString(1,bill_noin);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    int bill_id=rs.getInt("bill_id");
                    String bill_no= rs.getString("bill_no");
                    String bill_date = rs.getString("bill_date");
                    Float bill_actualamount= rs.getFloat("bill_actualamount");
                    Float bill_advanced= rs.getFloat("bill_advanced");
                    Float bill_dueamount= rs.getFloat("bill_dueamount");
                 
                    
                    bill.add(new Bill(bill_id,bill_no,bill_date,bill_actualamount,bill_advanced,bill_dueamount));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return bill;
    }
    
}
