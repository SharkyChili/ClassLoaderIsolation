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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        connection = (Connection)invoke;
        return connection;
    }
}
