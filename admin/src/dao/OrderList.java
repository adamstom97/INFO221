/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;
import domain.OrderItem;
import domain.Product;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Adams
 */
public class OrderList implements OrderDAO {

    private Integer orderID;
    private static SortedMap<Integer, Order> orders = new TreeMap<>();
    private static SortedMap<ItemKey, OrderItem> items = new TreeMap<>();

    @Override
    public void addOrder(Order order) {
        if (orders.isEmpty()) {
            orderID = 0;
        } else {
            orderID = orders.lastKey() + 1;
        }
        orders.put(orderID, order);

        for (OrderItem item : order.getItems()) {
            Integer productID = item.getProduct().getProductID();
            items.put(new ItemKey(orderID, productID),
                    item);
            ProductDAO list = new ProductList();
            Product p = list.getProductByID(Integer.toString(productID));
            p.setQuantity(p.getQuantity() - item.getQuantityPurchased());
            list.addProduct(p);
        }
    }

    @Override
    public Integer getOrderID() {
        return orderID;
    }

    @Override
    public Order getOrder(Integer orderID) {
        return orders.get(orderID);
    }

    @Override
    public ArrayList<OrderItem> getItems(Integer orderID) {
        ArrayList<OrderItem> subItems = new ArrayList<>();
        for (Map.Entry<ItemKey, OrderItem> entry : items.entrySet()) {
            ItemKey key = entry.getKey();
            OrderItem item = entry.getValue();

            if (orderID.equals(key.getOrderID())) {
                subItems.add(item);
            }
        }
        return subItems;
    }

    @Override
    public void deleteItems(Integer orderID) {
        for (Map.Entry<ItemKey, OrderItem> entry : items.entrySet()) {
            ItemKey key = entry.getKey();
            OrderItem item = entry.getValue();

            if (orderID.equals(key.getOrderID())) {
                items.remove(key);
            }
        }
    }

    @Override
    public void deleteOrder(Integer orderID) {
        orders.remove(orderID);
    }

    private class ItemKey implements Comparable<ItemKey> {

        private Integer orderID;
        private Integer productID;

        public ItemKey(Integer orderID, Integer productID) {
            this.orderID = orderID;
            this.productID = productID;
        }

        public Integer getOrderID() {
            return orderID;
        }

        public Integer getProductID() {
            return productID;
        }

        @Override
        public int compareTo(ItemKey other) {
            Integer myID = this.getOrderID();
            Integer theirID = other.getOrderID();
            return myID.compareTo(theirID);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.orderID);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ItemKey other = (ItemKey) obj;
            return Objects.equals(this.orderID, other.orderID);
        }
    }
}
