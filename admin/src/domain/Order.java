/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * A class containing all the information on a single transaction at the shop, 
 * including the customer making the order and a list of the products, and how 
 * many, that they are purchasing.
 * 
 * @author adath325
 * @version 2.0
 */
public class Order {
    private int orderID;
    
    /**
     * The date on which the order is made, to be set upon confirmation of the 
     * order.
     */
    private Date date;
    private Customer customer;
    
    /**
     * A list of the products that the customer is purchasing during the 
     * transaction, and how much. Constructed as each item is added to the list 
     * after it is chosen by the customer.
     */
    private ArrayList<OrderItem> items = new ArrayList<>();

    /**
     * A constructor for the order.
     * 
     * @param customer  the customer that is carrying out the transaction
     */
    public Order(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", date=" + date + 
                ", customer=" + customer + ", items=" + items + '}';
    }

    /**
     * @return orderID  {@link Order#orderID}
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID   {@link Order#orderID}
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    /**
     * @return date {@link Order#date}
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the order's date to the current real-world date, when called after 
     * the order is confirmed.
     */
    public void setDate() {
        this.date = new Date();
    }
    
    /**
     * Sums the total price of each item in the order.
     * 
     * @return the total price of the transaction
     */
    public double getTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
             total += item.getItemTotal();
        }
        return total;
    }
    
    /**
     * Adds a chosen item to the order's item list. If an item of the same 
     * product has already been added to the list, the list is streamlined by
     * adding the amount of the product newly requested to the amount already 
     * added, rather than adding the new item list.
     * 
     * @param item  an item selected by the customer that is to be added to the 
     *              order's item list
     */
    public void addItem(OrderItem item){
        int x = 0;
        boolean present = false;
        
        for (OrderItem i : items) {
            if (i.getProduct() == item.getProduct()) {
                present = true;
                x = items.indexOf(i);
            }
        }
        if (present == false) {
            items.add(item);
        } else {
            items.get(x).setQuantityPurchased(
                    items.get(x).getQuantityPurchased() + 
                    item.getQuantityPurchased());
        }
    }
}
