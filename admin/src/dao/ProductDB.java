/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * A dao class connected to the h2 database system, for products.
 * 
 * @author adath325
 * @version 4.0
 */
public class ProductDB implements ProductDAO {
    private String url = "jdbc:h2:tcp://localhost:9097/project;IFEXISTS=TRUE";

    /**
     * A default constructor for when the normal database is required.
     */
    public ProductDB() {
    }

    /**
     * A second constructor for when a different database is required.
     * 
     * @param url   the url of the requested database
     */
    public ProductDB(String url) {
        this.url = url;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "MERGE INTO products (productID, name, description, "
                + "category, price, quantity) VALUES (?,?,?,?,?,?)";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, product.getProductID());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getCategory());
            stmt.setDouble(5, product.getPrice());
            stmt.setInt(6, product.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        String sql = "DELETE FROM products WHERE productID = ?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, product.getProductID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Product> getProductList() {
        String sql = "SELECT * FROM products ORDER BY productID";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            Collection<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt("productID"), 
                        rs.getString("name"), rs.getString("description"), 
                        rs.getString("category"), rs.getDouble("price"), 
                        rs.getInt("quantity"));
                products.add(p);
            }
            return products;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> getCategoryList() {
        String sql = "SELECT DISTINCT category FROM products";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            Collection<String> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
            return categories;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public Product getProductByID(String productID) {
        String sql = "SELECT * FROM products WHERE productID = ?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            if (productID.equals("")) {
                return null;
            }
            stmt.setInt(1, Integer.parseInt(productID));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("productID"), 
                        rs.getString("name"), rs.getString("description"), 
                        rs.getString("category"), rs.getDouble("price"), 
                        rs.getInt("quantity"));
                return p;
            } else {
                return null;
            }            
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }       
    }

    @Override
    public Collection<Product> getProductsByCategory(String category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            Set<Product> products = new TreeSet<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt("productID"), 
                        rs.getString("name"), rs.getString("description"), 
                        rs.getString("category"), rs.getDouble("price"), 
                        rs.getInt("quantity"));
                products.add(p);
            } 
            return products;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }       
    }
}
