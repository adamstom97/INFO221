/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author adath325
 */
public class ProductJpa implements ProductDAO {

    private static final EntityManager MANAGER = Persistence
            .createEntityManagerFactory("productsPU").createEntityManager();

    @Override
    public void addProduct(Product product) {
        MANAGER.getTransaction().begin();
        MANAGER.merge(product);
        MANAGER.getTransaction().commit();
    }

    @Override
    public void deleteProduct(Product product) {
        MANAGER.getTransaction().begin();
        MANAGER.remove(product);
        MANAGER.getTransaction().commit();
    }

    @Override
    public Collection<Product> getProductList() {
        TypedQuery<Product> q = MANAGER.createQuery(
                "select p from Product p", Product.class);
        try {
            Collection<Product> products = q.getResultList();
            return products;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Collection<String> getCategoryList() {
        TypedQuery<Product> q = MANAGER.createQuery(
                "select p from Product p", Product.class);
        Collection<Product> products = q.getResultList();
        Collection<String> categories = new ArrayList<>();
        
        for (Product p : products) {
            if (!categories.contains(p.getCategory())) {
                categories.add(p.getCategory());
            }
        }
        return categories;
    }

    @Override
    public Product getProductByID(String productID) {
        Integer ID = Integer.parseInt(productID);
        TypedQuery<Product> q = MANAGER.createQuery(
                "select p from Product p where p.productID = :id",
                Product.class);
        q.setParameter("id", ID);
        try {
            Product product = q.getSingleResult();
            return product;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Collection<Product> getProductsByCategory(String category) {
        TypedQuery<Product> q = MANAGER.createQuery(
                "select p from Product p where p.category = :category",
                Product.class);
        q.setParameter("category", category);
        try {
            Collection<Product> list = q.getResultList();
            return list;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
