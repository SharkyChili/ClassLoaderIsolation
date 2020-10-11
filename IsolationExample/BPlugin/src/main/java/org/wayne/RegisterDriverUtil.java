package org.wayne;

public class RegisterDriverUtil {
    public static void register(String name) throws ClassNotFoundException {
        Class.forName(name);
    }
}
