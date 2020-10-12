package org.wayne;

import org.wayne.util.ClassLoaderUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerUtil {
    public static Connection getConnection(String url) throws SQLException {
        Class pluginClass = ClassLoaderUtil.getPluginClass(DriverManagerUtil.class);
        System.out.println("DriverManagerUtil : +" + DriverManagerUtil.class.getClassLoader());
        Connection connection;
        System.out.println("Connection : " + Connection.class.getClassLoader());
        Object invoke;
        try {
            Method method = pluginClass.getDeclaredMethod("getConnection", String.class);
            method.setAccessible(true);
            invoke = method.invoke(pluginClass.newInstance(), url);
            System.out.println("invoke : " + invoke);
            System.out.println("invoke : " + invoke.getClass().getClassLoader());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        connection = (Connection)invoke;
        System.out.println("connection : " + connection);
        System.out.println("connection : " + connection.getClass().getName());
        System.out.println("connection : " + connection.getClass().getClassLoader());
        System.out.println("Connection Class : " + Connection.class.getClassLoader());
        return connection;
    }
}
