/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.TreeSet;

/**
 * A data access object class for storing a list of all the products offered for 
 * sale at the shop, so they can be displayed to the user from ProductDisplay.
 * 
 * @author adath325
 * @version 1.0
 */
public class ProductList {
    
    /**
     * A list of the products offered for sale at the shop. Constructed as each 
     * product is added to the list once the user creates and saves them.
     */
    private static Collection<Product> products = new TreeSet<>();
    
    /**
     * A list of the categories that saved products belong to. Constructed as 
     * each new category is created along with a product and saved by the user.
     */
    private static Collection<String> categories = new TreeSet<>();
    
    /**
     * Adds a new product to the list of products offered for sale at the shop.
     * If the product belongs to a new category, that category is added to the
     * list of categories that saved products belong to.
     * 
     * @param product   a new product that the user has created and saved, to be
     *                  added to the list of saved products in the shop.
     */
    public void addProduct(Product product) {
        products.add(product);
        categories.add(product.getCategory());
    }
    
    public void deleteProduct(Product product) {
        products.remove(product);
    }
    
    /**
     * @return products {@link ProductList#products}
     */
    public Collection getProductList() {
        return products;
    }
    
    /**
     * @return categories   {@link ProductList#categories}
     */
    public Collection getCategoryList() {
        return categories;
    }
}
