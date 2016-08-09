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
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author adath325
 */
public class ProductDB implements DAO {

    private String url = "jdbc:h2:tcp://localhost:9097/project;IFEXISTS=TRUE";

    public ProductDB() {
    }

    public ProductDB(String url) {
        this.url = url;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "merge into products (productID, name, description, "
                + "category, price, quantity) values (?,?,?,?,?,?)";
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
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        String sql = "delete from products where productID = ?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, product.getProductID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Product> getProductList() {
        String sql = "select * from products order by productID";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            Collection<Product> products = new TreeSet<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                products.add(p);
            }
            return products;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<String> getCategoryList() {
        String sql = "select category from products";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            Collection<String> categories = new TreeSet<>();
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
            return categories;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Product getProductByID(String productID) {
    }

    @Override
    public Set<Product> getProductsByCategory(String category
    ) {
    }
}
