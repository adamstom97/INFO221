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
    private static ArrayList<domain.Product> products = new ArrayList<domain.Product>();
    private static ArrayList categories = new ArrayList();
    
    public void addProduct(domain.Product product) {
        products.add(product);
        categories.add(product.getCategory());
    }
    
    public ArrayList getProductList() {
        return products;
    }
    
    public ArrayList getCategoryList() {
        return categories;
    }
}
