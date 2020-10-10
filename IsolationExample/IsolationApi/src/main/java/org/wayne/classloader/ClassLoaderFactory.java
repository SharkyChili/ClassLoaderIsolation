package org.wayne.classloader;

import org.wayne.enums.EnvEnum;
import org.wayne.util.ClassLoaderUtil;

import java.net.URL;
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
        String path = ClassLoaderUtil.getRelativePath(envEnum);
        //todo
        //拿到项目根路径
        String path1 = ClassLoaderFactory.class.getClassLoader().getResource("").getPath();
        String[] isolationExamples = path1.split("IsolationExample");

        System.out.println("path: " + path);
        System.out.println("path1: "+ path1);

        return new SelfDefinedClassLoader(path);
    }
}
