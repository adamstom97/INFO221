/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Order;
import domain.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * A dao class connected to the h2 database system, for customers.
 * 
 * @author adamstom97
 * @version 4.0
 */
public class OrderDB implements OrderDAO {

    private String url = "jdbc:h2:tcp://localhost:9097/project;IFEXISTS=TRUE";
    private Integer orderID;

    /**
     * A default constructor for when the normal database is required.
     */
    public OrderDB() {
    }

    /**
     * A second constructor for when a different database is required.
     *
     * @param url the url of the requested database
     */
    public OrderDB(String url) {
        this.url = url;
    }

    @Override
    public void addOrder(Order order) {
        String sql1 = "INSERT INTO orders (date, customer) VALUES (?, ?)";
        String sql2 = "INSERT INTO items (quantity, price, parentOrder, "
                + "product) VALUES (?, ?, ?, ?)";
        String sql3 = "UPDATE products SET quantity=? WHERE productID=?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt1 = dbCon.prepareStatement(sql1);
                PreparedStatement stmt2 = dbCon.prepareStatement(sql2);
                PreparedStatement stmt3 = dbCon.prepareStatement(sql3);) {
            try {
                dbCon.setAutoCommit(false);

                stmt1.setTimestamp(1, new Timestamp(order.getDate().getTime()));
                stmt1.setString(2, order.getCustomer().getUserName());
                stmt1.executeUpdate();

                ResultSet rs = stmt1.getGeneratedKeys();
                if (rs.next()) {
                    orderID = rs.getInt(1);

                    for (OrderItem item : order.getItems()) {
                        Integer productID = item.getProduct().getProductID();
                        stmt2.setInt(1, item.getQuantityPurchased());
                        stmt2.setDouble(2, item.getItemTotal());
                        stmt2.setInt(3, orderID);
                        stmt2.setInt(4, productID);
                        stmt2.executeUpdate();

                        Integer currentQ = new ProductDB().getProductByID(
                                Integer.toString(productID)).getQuantity();
                        stmt3.setInt(1, currentQ - item.getQuantityPurchased());
                        stmt3.setInt(2, productID);
                        stmt3.executeUpdate();
                    }
                    dbCon.commit();
                }
            } catch (SQLException ex) {
                dbCon.rollback();
                throw new DaoException(ex.getMessage(), ex);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public Integer getOrderID() {
        return orderID;
    }

    @Override
    public Order getOrder(Integer orderID) {
        String sql1 = "SELECT * FROM orders WHERE orderID=?";
        String sql2 = "SELECT * FROM customers WHERE userName=?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt1 = dbCon.prepareStatement(sql1);
                PreparedStatement stmt2 = dbCon.prepareStatement(sql2);) {
            stmt1.setInt(1, orderID);
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                String user = rs.getString("customer");
                Date date = (Date) rs.getTimestamp("date");
                stmt2.setString(1, user);
                rs = stmt2.executeQuery();
                if (rs.next()) {
                    Customer customer = new CustomerDB().getCustomer(
                            user, rs.getString("password"));
                    Order order = new Order(customer);
                    order.setDate(date);
                    return order;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<OrderItem> getItems(Integer orderID) {
        String sql = "SELECT * FROM items WHERE parentOrder=?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, orderID);
            ResultSet rs = stmt.executeQuery();
            ArrayList<OrderItem> list = new ArrayList();
            while (rs.next()) {
                OrderItem item = new OrderItem(rs.getInt("quantity"),
                        new ProductDB().getProductByID(Integer.toString(
                                rs.getInt("product"))));
                list.add(item);
            }
            return list;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteItems(Integer orderID) {
        String sql = "DELETE FROM items WHERE parentOrder=?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, orderID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteOrder(Integer orderID) {
        String sql = "DELETE FROM orders WHERE orderID=?";
        try (Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, orderID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }
}
