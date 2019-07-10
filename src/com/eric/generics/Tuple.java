package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/12/2019 11:42 AM
 */
public class Tuple {

    public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<>(a,b);
    }

    public static void main(String[] args) {
        System.out.println(tuple("fd",12));
    }
}
