package org.wayne.inter;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wayne
 * @date 2020.10.15
 */
public interface DynamicDriverInter {

    void registerDriver(String driver) throws ClassNotFoundException;

    Connection getConnection(String url) throws SQLException;
}
