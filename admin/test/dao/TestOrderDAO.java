/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * A class for testing all of the project's customer dao classes.
 *
 * @author adamstom97
 * @version 3.0
 */
@RunWith(Parameterized.class)
public class TestOrderDAO {

    OrderDAO list;
    private Order order;
    private Integer orderID;
    private Order retrievedOrder;

    private Product product1;
    private Product product2;
    private OrderItem item1;
    private OrderItem item2;
    private OrderItem item3;

    private ArrayList<OrderItem> retrievedItems;
    private ProductDAO productList = new ProductList();
    private ProductDAO productDB = new ProductDB(
            "jdbc:h2:tcp://localhost:9097/project-testing;IFEXISTS=TRUE");

    @Parameterized.Parameters
    public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
            {new OrderList()},
            {new OrderDB(
                "jdbc:h2:tcp://localhost:9097/project-testing;IFEXISTS=TRUE")}
        });
    }

    public TestOrderDAO(OrderDAO list) {
        this.list = list;
    }

    @Before
    public void setUp() {
        product1 = new Product(1000000, "A", "Aa", "a", 1.00, 5);
        product2 = new Product(2000000, "B", "Bb", "b", 2.00, 5);
        order = new Order(
                new Customer("a", "A", "a@x.com", "123 B", "C", "password"));

        item1 = new OrderItem(3, product1);
        item2 = new OrderItem(1, product1);
        item3 = new OrderItem(2, product2);
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);

        productList.addProduct(product1);
        productList.addProduct(product2);
        productDB.addProduct(product1);
        productDB.addProduct(product2);
    }

    @Test
    public void testAddOrder() {
        list.addOrder(order);

        orderID = list.getOrderID();
        retrievedOrder = list.getOrder(orderID);
        retrievedItems = list.getItems(orderID);

        assertEquals("Retrieved order should be the same as the saved one",
                order, retrievedOrder);

        assertTrue("item1 should exist", retrievedItems.contains(item1));
        assertTrue("item1 should exist", retrievedItems.contains(item2));
        assertTrue("item1 should exist", retrievedItems.contains(item3));
        
        assertEquals("Stored product1 should have the new quantity", 
                new Integer(1), 
                productList.getProductByID("1000000").getQuantity());
        assertEquals("Stored product2 should have the new quantity", 
                new Integer(3), 
                productList.getProductByID("2000000").getQuantity());
    }

    @After
    public void tearDown() {
        productList.deleteProduct(product1);
        productList.deleteProduct(product2);
        productDB.deleteProduct(product1);
        productDB.deleteProduct(product2);
    }
}
