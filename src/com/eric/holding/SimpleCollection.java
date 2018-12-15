package com.eric.holding;

import java.util.Collection;
import java.util.HashSet;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 7:34 PM
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++)
            c.add(i);
        for (Integer i : c)
            System.out.print(i + " ,");
    }
}
