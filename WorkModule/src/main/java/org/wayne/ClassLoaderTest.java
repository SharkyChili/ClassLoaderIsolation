package org.wayne;

import org.wayne.classloader.ClassLoaderFactory;
import org.wayne.classloader.SelfDefinedClassLoader;
import org.wayne.enums.EnvEnum;

public class ClassLoaderTest {
    public static void main(String[] args) {
        SelfDefinedClassLoader loader = ClassLoaderFactory.getSelfDefinedClassLoader(EnvEnum.A);
        Class<?> aClass = null;
        try {
            aClass = loader.loadClass("org.wayne.App");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
    }
}
