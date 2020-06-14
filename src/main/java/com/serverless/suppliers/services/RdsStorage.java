package com.serverless.suppliers.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RdsStorage implements DataStorage {

    private static final Logger LOG = LogManager.getLogger(RdsStorage.class);

    String host = System.getenv("HOST");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    private static Connection conn;
    private static Statement stmt;

    public RdsStorage() {
        try {
            conn = DriverManager.getConnection(host, username, password);
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            LOG.info("Route Created: {}", "throwables.printStackTrace()");
            throwables.printStackTrace();
        }
    }

}
