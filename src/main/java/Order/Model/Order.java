/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Model;

/**
 *
 * @author dharm
 */
public class Order {
    String order_id;
    String customer_email;
    String product_code;
    String order_title;
    String order_date;
    String order_deliverydate;
    String order_status;
    Float order_amount;
    Float order_clothamount;
    Float order_discount;
    Float order_advance;
    Float order_totalamount;
    Float order_remainingamount;
    boolean is_paymentclear;
    String order_description;
    boolean is_billed;
    String bill_no;
    String taken_by;

    public Order() {
        
    }
    public Order(String order_id, String customer_email, String product_code, String order_title, String order_date, String order_deliverydate, String order_status, Float order_amount, Float order_clothamount, Float order_discount, Float order_advance, Float order_totalamount, Float order_remainingamount, boolean is_paymentclear, String order_description, boolean is_billed, String bill_no, String taken_by) {
        this.order_id = order_id;
        this.customer_email = customer_email;
        this.product_code = product_code;
        this.order_title = order_title;
        this.order_date = order_date;
        this.order_deliverydate = order_deliverydate;
        this.order_status = order_status;
        this.order_amount = order_amount;
        this.order_clothamount = order_clothamount;
        this.order_discount = order_discount;
        this.order_advance = order_advance;
        this.order_totalamount = order_totalamount;
        this.order_remainingamount = order_remainingamount;
        this.is_paymentclear = is_paymentclear;
        this.order_description = order_description;
        this.is_billed = is_billed;
        this.bill_no = bill_no;
        this.taken_by = taken_by;
    }
    
    public String getTaken_by() {
        return taken_by;
    }

    public void setTaken_by(String taken_by) {
        this.taken_by = taken_by;
    }
    

   

    public boolean isIs_billed() {
        return is_billed;
    }

    public void setIs_billed(boolean is_billed) {
        this.is_billed = is_billed;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_deliverydate() {
        return order_deliverydate;
    }

    public void setOrder_deliverydate(String order_deliverydate) {
        this.order_deliverydate = order_deliverydate;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Float getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Float order_amount) {
        this.order_amount = order_amount;
    }

    public Float getOrder_clothamount() {
        return order_clothamount;
    }

    public void setOrder_clothamount(Float order_clothamount) {
        this.order_clothamount = order_clothamount;
    }

    public Float getOrder_discount() {
        return order_discount;
    }

    public void setOrder_discount(Float order_discount) {
        this.order_discount = order_discount;
    }

    public Float getOrder_advance() {
        return order_advance;
    }

    public void setOrder_advance(Float order_advance) {
        this.order_advance = order_advance;
    }

    public Float getOrder_totalamount() {
        return order_totalamount;
    }

    public void setOrder_totalamount(Float order_totalamount) {
        this.order_totalamount = order_totalamount;
    }

    public Float getOrder_remainingamount() {
        return order_remainingamount;
    }

    public void setOrder_remainingamount(Float order_remainingamount) {
        this.order_remainingamount = order_remainingamount;
    }

    public boolean isIs_paymentclear() {
        return is_paymentclear;
    }

    public void setIs_paymentclear(boolean is_paymentclear) {
        this.is_paymentclear = is_paymentclear;
    }

    public String getOrder_description() {
        return order_description;
    }

    public void setOrder_description(String order_description) {
        this.order_description = order_description;
    }
    
    

    
}
