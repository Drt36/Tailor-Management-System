/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Model;

/**
 *
 * @author dharm
 */
public class Income {
    int income_id;
    String staff_email;
    String order_id;
    String product_code;
    Float amount;
    String income_date;

    public Income() {
    }

    public Income(int income_id, String staff_email, String order_id, String product_code, Float amount, String income_date) {
        this.income_id = income_id;
        this.staff_email = staff_email;
        this.order_id = order_id;
        this.product_code = product_code;
        this.amount = amount;
        this.income_date = income_date;
    }
    
    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getIncome_date() {
        return income_date;
    }

    public void setIncome_date(String income_date) {
        this.income_date = income_date;
    }
    

}
