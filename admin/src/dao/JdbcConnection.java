/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 * The connection to the h2 system for the JDBC dao class (ProductDB).
 * 
 * @author adath325
 * @version 2.0
 */
public class JdbcConnection {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";
    private static JdbcConnectionPool pool;

    public static Connection getConnection(String url) {
        if (pool == null) {
            pool = JdbcConnectionPool.create(url, USERNAME, PASSWORD);
        }
        try {
            return pool.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
