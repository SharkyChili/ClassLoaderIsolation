package org.wayne.impl;

import org.wayne.inter.ServiceOne;

/**
 * @author wayne
 * @date 2020.10.14
 */
public class BServiceOneImpl implements ServiceOne {
    @Override
    public String get() {
        System.out.println("BServiceOneImpl");
        return "BServiceOneImpl";
    }
}
