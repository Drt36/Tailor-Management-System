/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product.Model;

/**
 *
 * @author dharm
 */
public class Product {
    String product_code;
    String product_name;
    float product_cost;
    float product_paymentforstaff;
    boolean is_available;
    String product_description;
    String product_category;

    public Product(String product_code, String product_name, float product_cost, float product_paymentforstaff, boolean is_available, String product_description, String product_category) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_paymentforstaff = product_paymentforstaff;
        this.is_available = is_available;
        this.product_description = product_description;
        this.product_category = product_category;
    }
    
    
    public Product() {
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(float product_cost) {
        this.product_cost = product_cost;
    }

    public float getProduct_paymentforstaff() {
        return product_paymentforstaff;
    }

    public void setProduct_paymentforstaff(float product_paymentforstaff) {
        this.product_paymentforstaff = product_paymentforstaff;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }
    
    
    
}
