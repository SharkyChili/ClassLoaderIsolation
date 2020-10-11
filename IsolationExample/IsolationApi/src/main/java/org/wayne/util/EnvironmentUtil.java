package org.wayne.util;

import org.wayne.classloader.SelfDefinedClassLoader;
import org.wayne.enums.EnvEnum;

public class EnvironmentUtil {
    private static final ThreadLocal<EnvEnum> env = new ThreadLocal<>();
//    private static final ThreadLocal<ClassLoader> oldClassLoader = new ThreadLocal<>();

    public static void setEnv(EnvEnum envEnum){
        if(env.get()!=null){
            throw new RuntimeException("env has been set before, you should not invoke setEnv until clearEnv()");
        }
        env.set(envEnum);

//        oldClassLoader.set(Thread.currentThread().getContextClassLoader());
//        SelfDefinedClassLoader newCL = ClassLoaderUtil.getSelfDefinedClassLoaderByEnvironment();
//        Thread.currentThread().setContextClassLoader(newCL);
    }

    public static EnvEnum getEnv(){
        if(env.get()==null){
            throw new RuntimeException("environment empty, you should setEnv() before getEnv()");
        }
        return env.get();
    }

    public static void clearEnv(){
        env.remove();

//        Thread.currentThread().setContextClassLoader(oldClassLoader.get());
    }
}
