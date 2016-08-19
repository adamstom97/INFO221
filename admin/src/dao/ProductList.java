/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A data access object class for storing a list of all the products offered for 
 * sale at the shop, so they can be displayed to the user from ProductDisplay.
 * 
 * @author adath325
 * @version 2.0
 */
public class ProductList implements Dao {
    
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
    
    private static SortedMap<String, Product> productsByID = new TreeMap<>();
    private static SortedMap<String, Set<Product>> productsByCategory = new 
        TreeMap<>();
    
    @Override
    public void addProduct(Product product) {
        products.add(product);
        productsByID.put(product.getProductID().toString(), product);
        if (!categories.contains(product.getCategory())) {
            categories.add(product.getCategory());
            Set<Product> productsByCategoryInner = new TreeSet<>();
            productsByCategoryInner.add(product);
            productsByCategory.put(product.getCategory(), 
                    productsByCategoryInner);
        } else {
            Set<Product> productsByCategoryInner = 
                    productsByCategory.get(product.getCategory());
            productsByCategoryInner.add(product);        
        }
    }
    
    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
        productsByID.remove(product.getProductID().toString());
        productsByCategory.get(product.getCategory()).remove(product);
        if (productsByCategory.get(product.getCategory()).isEmpty()) {
            productsByCategory.remove(product.getCategory());
            categories.remove(product.getCategory());
        }
    }
          
    @Override
    public Collection<Product> getProductList() {
        return products;
    }
    
    @Override
    public Collection<String> getCategoryList() {
        return categories;
    }
    
    @Override
    public Product getProductByID(String productID) {
        return productsByID.get(productID);
    }
    
    @Override
    public Set<Product> getProductsByCategory(String category) {
        return productsByCategory.get(category);
    }
}
