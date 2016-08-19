/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Set;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * A class for testing all of the project's dao classes.
 * 
 * @author adath325
 * @version 2.0
 */
@RunWith(Parameterized.class)
public class daoTest {
    Dao list;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product retrieved;
    
    @Parameterized.Parameters
        public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
        {new ProductList()},
        {new ProductDB(
                "jdbc:h2:tcp://localhost:9097/project-testing;IFEXISTS=TRUE")}
        });
    }

    public daoTest(Dao list) {
        this.list = list;
    }
    
    @Before
        public void setUp() {
        this.product1 = new Product(1, "A", "Aa", "a", 1.00, 1);
        this.product2 = new Product(2, "B", "Bb", "b", 1.00, 1);
        this.product3 = new Product(3, "C", "Cc", "a", 1.00, 1);

        list.addProduct(product1);
        list.addProduct(product2);
        list.addProduct(product3);
    }

    @Test
    public void testAddProductAndDeleteProduct() {      
        product4 = new Product(4, "D", "dd", "b", 1.00, 1);
        
        list.addProduct(product4);
        retrieved = list.getProductByID("4");
        assertEquals("Retrieved product should be the same as the saved one",
        product4, retrieved);
    
        list.deleteProduct(product4);    
        retrieved = list.getProductByID("4");
        assertNull("Product should no longer exist", retrieved);
    }
    
    @Test
    public void testGetProductList() {     
        Collection<Product> products = list.getProductList();
        
        assertTrue("product1 should exist", products.contains(product1));
        assertTrue("product2 should exist", products.contains(product2));
        assertTrue("product3 should exist", products.contains(product3));
        assertEquals("Only 3 products should exist", 3, products.size());
        
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
    public void testGetCategoryList() {     
        Collection<String> categories = list.getCategoryList();
        
        assertTrue("Category a should exist", categories.contains("a"));
        assertTrue("Category b should exist", categories.contains("b"));
        assertEquals("Only 2 categories should exist", 2, categories.size());
    }
    
    @Test
    public void testGetProductByID() {
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
    
    @Test
    public void testGetProductsByCategory() {
        Set<Product> p = list.getProductsByCategory("a");
        
        assertTrue("Category a should contain product1", p.contains(product1));
        assertTrue("Category a should contain product3", p.contains(product3));
        assertEquals("Category a should only contain 2 products", 2, p.size());
    }
    
    @Test
    public void testEdit() {
        product1.setName("E");
        list.addProduct(product1);
        retrieved = list.getProductByID("1");
        
        assertEquals("product1 should now be called E", "E", 
                retrieved.getName());
    }
    
    @After
    public void tearDown() {
        list.deleteProduct(product1);
        list.deleteProduct(product2);
        list.deleteProduct(product3);
    }
}
