package com.eric.operators;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/15/2018 22:45
 */
public class Exercise10 {
    static byte b1 = 0x0;
    static byte b2 = 0x1;

    public static void main(String[] args) {
        print(b1 | b2);
        print(b1 & b2);
        print(b1 ^ b2);
        print(~b1);
        int b3 = -1;
        print(b3);
        b3 >>= 10;
        print(b3);
    }

    static void print(int o){
        System.out.println(Integer.toBinaryString(o));
    }
}
