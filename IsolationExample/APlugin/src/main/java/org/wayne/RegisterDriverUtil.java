package org.wayne;

public class RegisterDriverUtil {
    public void register(String name) throws ClassNotFoundException {
        Class.forName(name);
    }
}
