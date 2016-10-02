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
 * @version 4.0
 */
public class Order {

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
     * @param customer the customer that is carrying out the transaction
     */
    public Order(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return customer {@link Order#customer}
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param date {@link Order#date}
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return date {@link Order#date}
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sums the total price of each item in the order.
     *
     * @return the total price of the transaction
     */
    public Double getTotal() {
        Double total = 0.0;
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
     * @param item an item selected by the customer that is to be added to the
     * order's item list
     */
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }
}
