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
public class Bill {
  int bill_id;
  String bill_no;
  String bill_date;
  float bill_actualamount;
  float bill_advanced;
  float bill_dueamount;

    public Bill(int bill_id, String bill_no, String bill_date, float bill_actualamount, float bill_advanced, float bill_dueamount) {
        this.bill_id = bill_id;
        this.bill_no = bill_no;
        this.bill_date = bill_date;
        this.bill_actualamount = bill_actualamount;
        this.bill_advanced = bill_advanced;
        this.bill_dueamount = bill_dueamount;
    }

    public Bill() {
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public float getBill_actualamount() {
        return bill_actualamount;
    }

    public void setBill_actualamount(float bill_actualamount) {
        this.bill_actualamount = bill_actualamount;
    }

    public float getBill_advanced() {
        return bill_advanced;
    }

    public void setBill_advanced(float bill_advanced) {
        this.bill_advanced = bill_advanced;
    }

    public float getBill_dueamount() {
        return bill_dueamount;
    }

    public void setBill_dueamount(float bill_dueamount) {
        this.bill_dueamount = bill_dueamount;
    }
  
}
