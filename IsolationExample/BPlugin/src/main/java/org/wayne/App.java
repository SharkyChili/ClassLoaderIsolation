package org.wayne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public void registerDriver(String driver) throws Exception{
        Class.forName("org.wayne.Driver");
    }

    public Connection getConnection(String url) throws Exception{
//        Class.forName("org.wayne.Driver");
        Connection conn = DriverManager.getConnection("jdbc:wayne://172.19.1.49:7300/dwtmppdb");
        return conn;
    }

    public Statement createStatement(Connection conn) throws Exception{
        Statement statement = conn.createStatement();
        return statement;
    }
}
