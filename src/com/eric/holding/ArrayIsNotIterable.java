package com.eric.holding;

import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 9:07 PM
 */
public class ArrayIsNotIterable {

    public static <T> void test(Iterable<T> itr){
        for (T t : itr) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String []ar = "Hello world i am your !".split(" ");
        test(Arrays.asList(ar));
    }
}
