/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author adath325
 */
public class ProductList {
    private static ArrayList<domain.Product> products = new ArrayList<>();
    private static ArrayList<String> categories = new ArrayList<>();
    
    public void addProduct(domain.Product product) {
        products.add(product);
        if (!categories.contains(product.getCategory())) {
            categories.add(product.getCategory());
        }
    }
    
    public ArrayList getProductList() {
        return products;
    }
    
    public ArrayList getCategoryList() {
        return categories;
    }
}
