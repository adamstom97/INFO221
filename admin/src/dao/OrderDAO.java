/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;
import domain.OrderItem;
import java.util.ArrayList;

/**
 *
 * @author Adams
 */
public interface OrderDAO {
    public void addOrder(Order order);
    public Integer getOrderID();
    public Order getOrder(Integer orderID);
    public ArrayList<OrderItem> getItems(Integer orderID);
    public void deleteItems(Integer orderID);
    public void deleteOrder(Integer orderID);
}
