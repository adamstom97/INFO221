/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 * An interface for all the dao classes to implement.
 * 
 * @author adath325
 * @version 2.0
 */
public interface ProductDAO {
    public void addProduct(Product product);
    public void deleteProduct(Product product);
    public Collection<Product> getProductList();
    public Collection<String> getCategoryList();
    public Product getProductByID(String productID);
    public Collection<Product> getProductsByCategory(String category);
}