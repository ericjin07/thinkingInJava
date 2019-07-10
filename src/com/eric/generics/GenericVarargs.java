package com.eric.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 3:16 PM
 */
public class GenericVarargs {

    public <T> List<T> makeList(T...ts) {
        List<T> list = new ArrayList<>();
        for (T t : ts) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        GenericVarargs gv = new GenericVarargs();
        List<String> list = gv.makeList("a","b","c");
        System.out.println(list);
    }
}
