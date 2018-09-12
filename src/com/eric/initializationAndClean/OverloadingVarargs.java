package com.eric.initializationAndClean;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/05/2018 10:36 PM
 */
public class OverloadingVarargs {
    static void f(Integer ... integers){
        System.out.println("First");
        for (Integer i : integers)
            System.out.print(i);
        System.out.println();
    }

    static void f(Character ... characters){
        System.out.println("Second");
        for (Character i : characters)
            System.out.print(i);
        System.out.println();
    }

    static void f(Long ... longs){
        System.out.println("First");
        for (Long i : longs)
            System.out.print(i);
        System.out.println();
    }
    static void f(String ... strs){
        System.out.print("String");
        for (String s: strs)
            System.out.print(s);
        System.out.println();
    }

    public static void main(String[] args) {
        f('a','b','d');
        f(1,2,6);
        f(0L,3L);
        f(1,1);
        f("fasdf","fasdfadfa");
        f(new String[]{"fasdf","fasdfadfa"});
    }
}
