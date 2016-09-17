/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
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
public class TestCustomerDAO {

    CustomerDAO list;
    private Customer customer;
    private Customer retrieved;

    @Parameterized.Parameters
    public static Collection<?> daoObjectsToTest() {
        return Arrays.asList(new Object[][]{
            {new CustomerList()},
            {new CustomerDB(
                "jdbc:h2:tcp://localhost:9097/project-testing;IFEXISTS=TRUE")}
        });
    }

    public TestCustomerDAO(CustomerDAO list) {
        this.list = list;
    }

    @Before
    public void setUp() {}

    @Test
    public void testLogIn() {
        customer = new Customer("adamstom97", "Tom Adams", "adamstom97@gmail.com", "396 Hillboro Road, Timaru", "MasterCard", "password");

        list.addCustomer(customer);
        retrieved = list.getCustomer("adamstom97", "password");

        assertEquals("Retrieved customer should be the same as the saved one",
                customer, retrieved);
        assertEquals("The customer's username should be the same as customer2's", 
                customer.getUserName(), retrieved.getUserName());
        assertEquals("The customer's name should be the same as customer2's", 
                customer.getName(), retrieved.getName());
        assertEquals("The customer's email should be the same as customer2's", 
                customer.getEmail(), retrieved.getEmail());
        assertEquals("The customer's address should be the same as customer2's", 
                customer.getAddress(), retrieved.getAddress());
        assertEquals("The customer's credit card should be the same as customer2's", 
                customer.getCreditCardDetails(), retrieved.getCreditCardDetails());
        assertEquals("The customer's password should be the same as customer2's", 
                customer.getPassword(), retrieved.getPassword());
        
        list.deleteCustomer(customer);
        retrieved = list.getCustomer("adamstom97", "password");
        assertNull("Customer should no longer exist", retrieved);
    }

    @After
    public void tearDown() {}
}
