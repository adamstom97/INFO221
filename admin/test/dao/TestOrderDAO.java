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
import java.util.Date;
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

    private Customer customer;
    private Product product1;
    private Product product2;
    private OrderItem item1;
    private OrderItem item2;

    private static String url = 
            "jdbc:h2:tcp://localhost:9097/project-testing;IFEXISTS=TRUE";
    private ArrayList<OrderItem> retrievedItems;
    private CustomerDAO customerList = new CustomerList();
    private CustomerDAO customerDB = new CustomerDB(url);
    private ProductDAO productList = new ProductList();
    private ProductDAO productDB = new ProductDB(url);

    @Parameterized.Parameters
    public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
            {new OrderList()},
            {new OrderDB(url)}
        });
    }

    public TestOrderDAO(OrderDAO list) {
        this.list = list;
    }

    @Before
    public void setUp() {
        product1 = new Product(1000000, "A", "Aa", "a", 1.00, 5);
        product2 = new Product(2000000, "B", "Bb", "b", 2.00, 5);
        customer = new Customer("a", "A", "a@x.com", "123 B", "C", "password");
        order = new Order(customer);

        item1 = new OrderItem(3, product1);
        item2 = new OrderItem(2, product2);
        order.addItem(item1);
        order.addItem(item2);

        if (list.getClass() == OrderList.class) {
            customerList.addCustomer(customer);
            productList.addProduct(product1);
            productList.addProduct(product2);
        } else {
            customerDB.addCustomer(customer);
            productDB.addProduct(product1);
            productDB.addProduct(product2);
        }
    }

    @Test
    public void testAddOrder() {
        order.setDate(new Date());
        list.addOrder(order);

        orderID = list.getOrderID();
        retrievedOrder = list.getOrder(orderID);
        retrievedItems = list.getItems(orderID);

        assertEquals("Retrieved order should have the same customer",
                order.getCustomer(), retrievedOrder.getCustomer());
        assertEquals("Retrieved order should have the same date",
                order.getDate(), retrievedOrder.getDate());
       
        assertEquals("Retrieved order should have the same amount of items",
                2, retrievedItems.size());
        
        assertEquals("Item1 should have the same quantity",
                new Integer(3), retrievedItems.get(0).getQuantityPurchased());
        assertEquals("Item1 shoud have the same product",
                product1, retrievedItems.get(0).getProduct());
        
        assertEquals("Item2 should have the same quantity",
                new Integer(2), retrievedItems.get(1).getQuantityPurchased());
        assertEquals("Item2 should have the same product",
                product2, retrievedItems.get(1).getProduct());

        if (list.getClass() == OrderList.class) {
            assertEquals("Stored product1 should have the new quantity",
                    new Integer(2),
                    productList.getProductByID("1000000").getQuantity());
            assertEquals("Stored product2 should have the new quantity",
                    new Integer(3),
                    productList.getProductByID("2000000").getQuantity());
        } else {
            assertEquals("Stored product1 should have the new quantity",
                    new Integer(2),
                    productDB.getProductByID("1000000").getQuantity());
            assertEquals("Stored product2 should have the new quantity",
                    new Integer(3),
                    productDB.getProductByID("2000000").getQuantity());
        }
    }

    @After
    public void tearDown() {
        list.deleteItems(orderID);
        list.deleteOrder(orderID);

        if (list.getClass() == OrderList.class) {
            customerList.deleteCustomer(customer);
            productList.deleteProduct(product1);
            productList.deleteProduct(product2);
        } else {
            customerDB.deleteCustomer(customer);
            productDB.deleteProduct(product1);
            productDB.deleteProduct(product2);
        }
    }
}
