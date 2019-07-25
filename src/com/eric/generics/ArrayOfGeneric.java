package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 2:40 PM
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
//        gia = (Generic<Integer>[]) new Object[SIZE];      //compiles , but produce ClassCastException
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());

        gia[0] = new Generic<>();
//        gia[1] = new Object();        //compile error
    }
}
