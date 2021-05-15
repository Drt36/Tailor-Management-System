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
public class Design {
    int design_id;
    String order_id;
    String design_url;

    public Design() {
    }

    public Design(int measurment_id, String order_id, String design_url) {
        this.design_id = measurment_id;
        this.order_id = order_id;
        this.design_url = design_url;
    }

    public int getDesign_id() {
        return design_id;
    }

    public void setDesign_id(int measurment_id) {
        this.design_id = measurment_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDesign_url() {
        return design_url;
    }

    public void setDesign_url(String design_url) {
        this.design_url = design_url;
    }
    
    
    
}
