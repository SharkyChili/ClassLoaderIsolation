package org.wayne.util;

import org.wayne.enums.EnvEnum;

public class EnvironmentUtil {
    private static final ThreadLocal<EnvEnum> env = new ThreadLocal<>();

    public static void setEnv(EnvEnum envEnum){
        if(env.get()!=null){
            throw new RuntimeException("env has been set before, you should not invoke setEnv until clearEnv()");
        }
        env.set(envEnum);
    }

    public static EnvEnum getEnv(){
        if(env.get()==null){
            throw new RuntimeException("environment empty, you should setEnv() before getEnv()");
        }
        return env.get();
    }

    public static void clearEnv(){
        env.remove();
    }
}
