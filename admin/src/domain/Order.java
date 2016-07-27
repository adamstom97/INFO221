/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adath325
 */
public class Order {
    private int orderID;
    private Date date = new Date();
    private ArrayList<OrderItem> items = new ArrayList<>();

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public double getTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
             total += item.getItemTotal();
        }
        return total;
    }
    
    public void addItem(OrderItem item){
        items.add(item);
    }
}
