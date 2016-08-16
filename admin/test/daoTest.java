/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DAO;
import dao.ProductDB;
import domain.Product;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adath325
 */
public class daoTest {
    DAO list = new ProductDB();
    private Product product1;
    private Product product2;
    private Product product3;
    
    public daoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
        public void setUp() {
        this.product1 = new Product(1, "A", "aa", "a", 1.00, 1);
        this.product2 = new Product(2, "B", "bb", "b", 1.00, 1);
        this.product3 = new Product(3, "C", "cc", "a", 1.00, 1);

        list.addProduct(product1);
        list.addProduct(product2);
        list.addProduct(product3);
    }
    
    @After
    public void tearDown() {
        list.deleteProduct(product1);
        list.deleteProduct(product2);
        list.deleteProduct(product3);
    }

    @Test
    public void testDAOAddAndDelete() {      
        Product saved = new Product(4, "D", "dd", "b", 1.00, 1);
        list.addProduct(saved);
        Product retrieved = list.getProductByID("4");
        
        assertEquals("Retrieved product should be the same as the saved one",
        saved, retrieved);
        
        list.deleteProduct(saved);    
        retrieved = list.getProductByID("4");
        assertNull("Product should no longer exist", retrieved);
    }
    
    @Test
    public void testDAOGetAllProducts() {     
        Collection<Product> products = list.getProductList();
        assertTrue("product1 should exist", products.contains(product1));
        assertTrue("product2 should exist", products.contains(product2));
        assertTrue("product3 should exist", products.contains(product3));

        assertEquals("Only 3 products in result", 3, products.size());
        
        for (Product p : products) {
            if (p.equals(product1)) {          
                assertEquals(product1.getProductID(), p.getProductID());
                assertEquals(product1.getName(), p.getName());
                assertEquals(product1.getDescription(), p.getDescription());
                assertEquals(product1.getCategory(), p.getCategory());
                assertEquals(product1.getPrice(), p.getPrice());
                assertEquals(product1.getQuantity(), p.getQuantity());
            }
        }
    }
    
    @Test
    public void testDaoFindById() {
        Product p = list.getProductByID("1");
        assertEquals(product1, p);
        assertEquals(product1.getProductID(), p.getProductID());
        assertEquals(product1.getName(), p.getName());
        assertEquals(product1.getDescription(), p.getDescription());
        assertEquals(product1.getCategory(), p.getCategory());
        assertEquals(product1.getPrice(), p.getPrice());
        assertEquals(product1.getQuantity(), p.getQuantity());
        
        Product p2 = list.getProductByID("5");
        assertEquals(p2, null);
    }
}
