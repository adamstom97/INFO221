/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;

/**
 * An interface for all the dao classes to implement.
 * 
 * @author adath325
 * @version 2.0
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public Customer getCustomer(String userName, String password);
}