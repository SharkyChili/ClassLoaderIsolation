package org.wayne;

import org.wayne.util.ClassLoaderUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerUtil {
    public static Connection getConnection(String url) throws SQLException {
        Class pluginClass = ClassLoaderUtil.getPluginClass(DriverManagerUtil.class);
        Connection connection;
        Object invoke;
        try {
            Method method = pluginClass.getDeclaredMethod("getConnection", String.class);
            method.setAccessible(true);
            invoke = method.invoke(pluginClass.newInstance(), url);
            System.out.println("invoke : " + invoke.getClass().getClassLoader());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        connection = (Connection)invoke;
        System.out.println("Connection : " + Connection.class.getClassLoader());
        System.out.println("connection : " + connection.getClass().getClassLoader());
        return connection;
    }
}
