package org.wayne;

import org.wayne.classloader.ClassLoaderFactory;
import org.wayne.classloader.SelfDefinedClassLoader;
import org.wayne.enums.EnvEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        classLoaderTest.testCL(EnvEnum.A);
        classLoaderTest.testCL(EnvEnum.B);
    }

    public void testCL(EnvEnum envEnum){
        SelfDefinedClassLoader loader = ClassLoaderFactory.getSelfDefinedClassLoader(envEnum);
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
