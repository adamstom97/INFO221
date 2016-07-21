/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author adath325
 */
public class Order {
    private int orderID;
    private int date;

    public int getOrderID() {
        return orderID;
    }
    /* Code to generate orderID
    public void setOrderID(int orderID) {
         
    }
    */
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    /* Code to get Order total
    public int getTotal() {
         
    }
    
    public void addItem(orderItem){
        
    }
    */
}
