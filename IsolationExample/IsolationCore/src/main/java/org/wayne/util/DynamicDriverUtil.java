package org.wayne.util;



import org.wayne.inter.DynamicDriverInter;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wayne
 * @date 2020.10.15
 */
public class DynamicDriverUtil {
    public static void registerDriver(String driver) throws ClassNotFoundException{
        DynamicDriverInter dynamicDriverInter = ClassLoaderUtil.getPluginClassBySpi(DynamicDriverInter.class);
        dynamicDriverInter.registerDriver(driver);
    }

    public static Connection getConnection(String url) throws SQLException{
        DynamicDriverInter dynamicDriverInter = ClassLoaderUtil.getPluginClassBySpi(DynamicDriverInter.class);
        return dynamicDriverInter.getConnection(url);
    }
}
