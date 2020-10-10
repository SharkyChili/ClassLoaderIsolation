package org.wayne.classloader;

import org.wayne.enums.EnvEnum;
import org.wayne.util.ClassLoaderUtil;

import java.util.HashMap;
import java.util.Map;

public class ClassLoaderFactory {
    //因为getSelfDefinedClassLoader用了synchronized，因此不必用ConcurrentHashMap
    private static final Map<EnvEnum, SelfDefinedClassLoader> classLoaderMap =
            new HashMap<>();

    public static synchronized SelfDefinedClassLoader getSelfDefinedClassLoader(EnvEnum envEnum){
        SelfDefinedClassLoader loader = classLoaderMap.get(envEnum);
        if(loader!=null){
            return loader;
        }else {
            SelfDefinedClassLoader newLoader = buildCL(envEnum);
            classLoaderMap.put(envEnum, newLoader);
            return newLoader;
        }
    }

    private static SelfDefinedClassLoader buildCL(EnvEnum envEnum){
        //首先拿到path
        //todo 这个path肯定要改的
        String path = ClassLoaderUtil.getModuleName(envEnum);
        //todo
        return new SelfDefinedClassLoader(path);
    }
}
