/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A data access object class for storing a list of all the customers of the 
 * shop.
 * 
 * @author adamstom97
 * @version 3.0
 */
public class CustomerList implements CustomerDAO {

    /**
     * A list of customers, sorted by userName.
     */
    private static SortedMap<String, Customer> list = new TreeMap<>();

    @Override
    public void addCustomer(Customer customer) {
        list.put(customer.getUserName(), customer);
    }

    @Override
    public Customer getCustomer(String userName, String password) {
        Customer customer = list.get(userName);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
    
    @Override
    public void deleteCustomer(Customer customer) {
        list.remove(customer.getUserName());
    }
}
