/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author adath325
 */
public interface DAO {
    public void addProduct(Product product);
    public void deleteProduct(Product product);
    public Collection<Product> getProductList();
    public Collection<String> getCategoryList();
    public Product getProductByID(String productID);
    public Set<Product> getProductsByCategory(String category);
}
