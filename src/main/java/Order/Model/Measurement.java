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
public class Measurement {
    int measurment_id;
    String order_id;
    String measurment_title;
    Float length; 
    Float waist;
    Float shoulder;
    Float length_of_hand;
    Float neck; 
    Float chest;
    Float thigh; 
    Float inner_lenght;
    Float hip;

    public Measurement() {
    }

    public Measurement(int measurment_id, String order_id, String measurment_title, Float length, Float waist, Float shoulder, Float length_of_hand, Float neck, Float chest, Float thigh, Float inner_lenght, Float hip) {
        this.measurment_id = measurment_id;
        this.order_id = order_id;
        this.measurment_title = measurment_title;
        this.length = length;
        this.waist = waist;
        this.shoulder = shoulder;
        this.length_of_hand = length_of_hand;
        this.neck = neck;
        this.chest = chest;
        this.thigh = thigh;
        this.inner_lenght = inner_lenght;
        this.hip = hip;
    }

    public int getMeasurment_id() {
        return measurment_id;
    }

    public void setMeasurment_id(int measurment_id) {
        this.measurment_id = measurment_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    

    public String getMeasurment_title() {
        return measurment_title;
    }

    public void setMeasurment_title(String measurment_title) {
        this.measurment_title = measurment_title;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWaist() {
        return waist;
    }

    public void setWaist(Float waist) {
        this.waist = waist;
    }

    public Float getShoulder() {
        return shoulder;
    }

    public void setShoulder(Float shoulder) {
        this.shoulder = shoulder;
    }

    public Float getLength_of_hand() {
        return length_of_hand;
    }

    public void setLength_of_hand(Float length_of_hand) {
        this.length_of_hand = length_of_hand;
    }

    public Float getNeck() {
        return neck;
    }

    public void setNeck(Float neck) {
        this.neck = neck;
    }

    public Float getChest() {
        return chest;
    }

    public void setChest(Float chest) {
        this.chest = chest;
    }

    public Float getThigh() {
        return thigh;
    }

    public void setThigh(Float thigh) {
        this.thigh = thigh;
    }

    public Float getInner_lenght() {
        return inner_lenght;
    }

    public void setInner_lenght(Float inner_lenght) {
        this.inner_lenght = inner_lenght;
    }

    public Float getHip() {
        return hip;
    }

    public void setHip(Float hip) {
        this.hip = hip;
    }
    
    
}
