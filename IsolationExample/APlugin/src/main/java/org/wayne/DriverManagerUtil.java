package org.wayne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerUtil {
    public Connection getConnection(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        System.out.println("DriverManager :：：：：：：：：：：：： +" + DriverManager.class.getClassLoader());
        return connection;
    }
}
