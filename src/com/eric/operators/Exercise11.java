package com.eric.operators;

import java.io.PrintStream;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/16/2018 20:21
 */
public class Exercise11 {

    public static void main(String[] args) {
        int a = -0x1ff;
        int inx = 0;
        while (a > 0 || inx < 10) {
            a >>>= 1;
            inx++;
            System.out.println(Integer.toBinaryString(a));
        }
        printChar('f');
    }

    static void printChar(char c) {
        System.out.println(Integer.toBinaryString(c));
    }
}
