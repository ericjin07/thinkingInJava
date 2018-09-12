package com.eric.control;

import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/28/2018 17:27
 */
public class WhileTest {
    static String se;
    static boolean condition(){
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

    public static void main(String[] args) {
        while (condition())
            System.out.println("inside  'while'");
        System.out.println("outside 'while'");
        System.out.println(se);
    }
}
