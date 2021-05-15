/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Database;

import Product.Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dharm
 */
public class ProductAllData {
    public Product getAllDataOfProduct(String product_code)throws ClassNotFoundException, SQLException {
         Product product=null;
            
          Class.forName("com.mysql.cj.jdbc.Driver");

          try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tmswdr", "root", "");

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where  product_code= ? ")) {
            preparedStatement.setString(1,product_code);
            
            ResultSet rs = preparedStatement.executeQuery();
            
             while (rs.next()) {
                    product=new Product();
                    product.setProduct_code(rs.getString("product_code"));
                    product.setProduct_name(rs.getString("product_name"));
                    product.setProduct_cost(rs.getFloat("product_cost"));
                    product.setProduct_paymentforstaff(rs.getFloat("product_paymentforstaff"));
                    product.setIs_available(rs.getBoolean("is_available"));
                    product.setProduct_description(rs.getString("product_description"));
                    product.setProduct_category(rs.getString("product_category"));
                    
                }

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return product;
    }
    
}
