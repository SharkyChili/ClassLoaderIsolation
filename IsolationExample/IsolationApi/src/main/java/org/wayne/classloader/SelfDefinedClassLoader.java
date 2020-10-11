package org.wayne.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.List;

public class SelfDefinedClassLoader extends URLClassLoader {

    public SelfDefinedClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public SelfDefinedClassLoader(URL[] urls) {
        super(urls);
    }

    public SelfDefinedClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public SelfDefinedClassLoader(String path){
        //父加载器用SelfDefinedClassLoader的加载器，此时多半是ApplicationClassLoader
        this(path, SelfDefinedClassLoader.class.getClassLoader());
    }

    public SelfDefinedClassLoader(String path, ClassLoader parent){
        this(buildURLs(path),parent);
    }

    private static URL[] buildURLs(String path){
        List<URL> urls = new ArrayList<>();
        File jarPath = new File(path);
        URL url;
        try {
            url = jarPath.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("something goes wrong when load jars.");
        }
        urls.add(url);
        URL[] array = urls.toArray(new URL[0]);
        return array;
    }
}
