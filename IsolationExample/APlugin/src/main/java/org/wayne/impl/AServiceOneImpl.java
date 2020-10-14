package org.wayne.impl;


import org.wayne.inter.ServiceOne;

/**
 * @author wayne
 * @date 2020.10.14
 */
public class AServiceOneImpl implements ServiceOne {
    @Override
    public String get() {
        System.out.println("AServiceOneImpl");
        return "AServiceOneImpl";
    }
}
