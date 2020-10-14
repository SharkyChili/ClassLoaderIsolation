package org.wayne.classloader;

import org.wayne.enums.EnvEnum;
import org.wayne.util.ClassLoaderUtil;

import java.io.File;
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
//        System.out.println("buildCL");
        String pluginPath = ClassLoaderUtil.getRelativePath(envEnum);
//        System.out.println(pluginPath);
        //拿到项目根路径
//        System.out.println(ClassLoaderFactory.class.getClassLoader());
        //System.out.println(ClassLoaderFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//        System.out.println(ClassLoaderFactory.class.getClassLoader().getResource("/"));
//        String path1 = ClassLoaderFactory.class.getClassLoader().getResource("/").getPath();
        String jarPath = ClassLoaderFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        String[] projectPath = jarPath.split("target");

        String dependencyPath =
                projectPath[0] + pluginPath;
//        System.out.println("dependencyPath" + dependencyPath);
        return new SelfDefinedClassLoader(dependencyPath);
    }
}
