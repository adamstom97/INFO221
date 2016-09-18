/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;

/**
 * An interface for all the customer dao classes to implement.
 * 
 * @author adamstom97
 * @version 3.0
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public Customer getCustomer(String userName, String password);
    public void deleteCustomer(Customer customer);
}