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
public class Salary {
    int salary_id;
    String staff_email;
    String salary_date;
    Float amount;

    public Salary() {
    }

    public Salary(int salary_id, String staff_email, String salary_date, Float amount) {
        this.salary_id = salary_id;
        this.staff_email = staff_email;
        this.salary_date = salary_date;
        this.amount = amount;
    }

    public int getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {
        this.salary_id = salary_id;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getSalary_date() {
        return salary_date;
    }

    public void setSalary_date(String salary_date) {
        this.salary_date = salary_date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
}
