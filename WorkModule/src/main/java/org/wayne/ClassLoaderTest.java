package org.wayne;

import org.wayne.classloader.SelfDefinedClassLoader;
import org.wayne.enums.EnvEnum;
import org.wayne.inter.ServiceOne;
import org.wayne.util.ClassLoaderUtil;
import org.wayne.util.EnvironmentUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassLoaderTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    /**
     * java  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     */
    public static void test6() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        EnvironmentUtil.setEnv(EnvEnum.A);
        ServiceOne aClass = ClassLoaderUtil.getPluginClassBySpi(ServiceOne.class);
        classLoaderTest.testSpiUtil(aClass);
        EnvironmentUtil.clearEnv();

        System.out.println("*****************************");

        EnvironmentUtil.setEnv(EnvEnum.B);
        ServiceOne bClass = ClassLoaderUtil.getPluginClassBySpi(ServiceOne.class);
        classLoaderTest.testSpiUtil(bClass);
        EnvironmentUtil.clearEnv();
    }

    /**
     * java -Denv="A"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     * or
     * java -Denv="B"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     */
    public static void test5() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        ServiceOne aClass = ClassLoaderUtil.getPluginClassBySpi(ServiceOne.class);
        classLoaderTest.testSpiUtil(aClass);
    }

    private void testSpiUtil(ServiceOne aClass) {
        aClass.get();
    }


    /**
     * java -Denv="A"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     * or
     * java -Denv="B"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     */
    public static void test4() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        //不手动设置了
//        EnvironmentUtil.setEnvBySystemParam();
        classLoaderTest.testRegisterAndConnection();
    }

    /**
     * java -Denv="A"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     * or
     * java -Denv="B"  -cp WorkModule_WithDenpendency.jar org.wayne.ClassLoaderTest
     */
    public static void test3() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        EnvironmentUtil.setEnvBySystemParam();
        classLoaderTest.testRegisterAndConnection();
    }


    public static void test2() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        EnvironmentUtil.setEnv(EnvEnum.A);
        classLoaderTest.testRegisterAndConnection();
        EnvironmentUtil.clearEnv();

        System.out.println("*****************************");

        EnvironmentUtil.setEnv(EnvEnum.B);
        classLoaderTest.testRegisterAndConnection();
        EnvironmentUtil.clearEnv();

    }

    public void testRegisterAndConnection() {
        RegisterDriverUtil.register("org.wayne.Driver");

        Connection connection = null;
        try {
            connection = DriverManagerUtil.getConnection("jdbc:wayne://172.19.1.49:7300/dwtmppdb");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----");
        System.out.println("connection : " + connection);
        System.out.println("connection : " + connection.getClass().getName());
        System.out.println("connection : " + connection.getClass().getClassLoader());
        //System.out.println("Connection Class : " + Connection.class.getClassLoader());
        System.out.println("----");

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (statement != null) {
            System.out.println("statement : " + statement);
            System.out.println("statement : " + statement.getClass().getName());
            System.out.println("statement : " + statement.getClass().getClassLoader());
            //System.out.println("Statement Class : " + Statement.class.getClassLoader());
        } else {
            System.out.println("statement : null");
        }
    }

    public static void test1() {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        EnvironmentUtil.setEnv(EnvEnum.A);
        classLoaderTest.testCL();
        EnvironmentUtil.clearEnv();

        EnvironmentUtil.setEnv(EnvEnum.B);
        classLoaderTest.testCL();
        EnvironmentUtil.clearEnv();
    }


    public void testCL() {
        SelfDefinedClassLoader loader = ClassLoaderUtil.getSelfDefinedClassLoaderByEnvironment();
        //SelfDefinedClassLoader loader = ClassLoaderFactory.getSelfDefinedClassLoader(envEnum);
        Class<?> aClass = null;
        try {
            //System.out.println("java.class.path : " + System.getProperty("java.class.path"));
            aClass = loader.loadClass("org.wayne.App");
            Method met = aClass.getDeclaredMethod("met");
            met.invoke(aClass.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
    }
}
