/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A dao class connected to the h2 database system.
 *
 * @author adath325
 * @version 2.0
 */
public class CustomerDB implements CustomerDAO {

    private String url = "jdbc:h2:tcp://localhost:9097/project;IFEXISTS=TRUE";

    /**
     * A default constructor for when the normal database is required.
     */
    public CustomerDB() {
    }

    /**
     * A second constructor for when a different database is required.
     *
     * @param url the url of the requested database
     */
    public CustomerDB(String url) {
        this.url = url;
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = "merge into customers (userName, name, email, address,"
                + " creditCardDetails, password) values (?,?,?,?,?,?)";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getCreditCardDetails());
            stmt.setString(6, customer.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public Customer getCustomer(String userName, String password) {
        String sql = "select * from customers where (userName=?) and (password=?)";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getString("userName"),
                        rs.getString("name"), rs.getString("email"),
                        rs.getString("address"), rs.getString("creditCardDetails"),
                        rs.getString("password"));
                return customer;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }
}
