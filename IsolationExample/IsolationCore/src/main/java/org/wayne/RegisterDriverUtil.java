package org.wayne;

import org.wayne.util.ClassLoaderUtil;

import java.lang.reflect.Method;

public class RegisterDriverUtil {
    public static void register(String name){
        Class pluginClass = ClassLoaderUtil.getPluginClass(RegisterDriverUtil.class);
        try {
            Method method = pluginClass.getDeclaredMethod("register", String.class);
            method.setAccessible(true);
            method.invoke(pluginClass.newInstance(),name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
