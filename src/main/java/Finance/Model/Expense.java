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
public class Expense {
    String expense_id;
    String expense_title;
    Float expense_amount;
    String expense_description;
    String expense_creator;
    String expense_date;

    public Expense() {
    }

    public Expense(String expense_id, String expense_title, Float expense_amount, String expense_description, String expense_creator, String expense_date) {
        this.expense_id = expense_id;
        this.expense_title = expense_title;
        this.expense_amount = expense_amount;
        this.expense_description = expense_description;
        this.expense_creator = expense_creator;
        this.expense_date = expense_date;
    }

    public String getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(String expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpense_title() {
        return expense_title;
    }

    public void setExpense_title(String expense_title) {
        this.expense_title = expense_title;
    }

    public Float getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(Float expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getExpense_description() {
        return expense_description;
    }

    public void setExpense_description(String expense_description) {
        this.expense_description = expense_description;
    }

    public String getExpense_creator() {
        return expense_creator;
    }

    public void setExpense_creator(String expense_creator) {
        this.expense_creator = expense_creator;
    }

    public String getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }
    

    
}
