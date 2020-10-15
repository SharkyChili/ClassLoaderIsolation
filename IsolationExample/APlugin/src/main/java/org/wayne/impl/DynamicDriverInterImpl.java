package org.wayne.impl;

import org.wayne.inter.DynamicDriverInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wayne
 * @date 2020.10.15
 */
public class DynamicDriverInterImpl implements DynamicDriverInter {
    @Override
    public void registerDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
    }

    @Override
    public Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url);
    }
}