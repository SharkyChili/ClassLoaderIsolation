package org.wayne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        Class.forName("org.wayne.Driver");
        Connection conn = DriverManager.getConnection("jdbc:wayne://172.19.1.49:7300/dwtmppdb");
        Statement statement = conn.createStatement();

        /*Class.forName("org.wayne.Driver");
        Connection connection = DriverManager.getConnection("jdbc:wayne://172.19.1.49:7300/dwtmppdb");
        Statement statement1 = conn.createStatement();*/

    }
}
