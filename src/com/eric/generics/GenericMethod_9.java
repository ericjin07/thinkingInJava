package com.eric.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 2:51 PM
 */
public class GenericMethod_9 {

    public <T, E> void f(T t, E e, String u){
        System.out.println(t.getClass().getSimpleName());
        System.out.println(e.getClass().getSimpleName());
        System.out.println(u.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethod_9 gm = new GenericMethod_9();
        gm.f(1,new GenericMethod_9(), "ste");
    }
}
