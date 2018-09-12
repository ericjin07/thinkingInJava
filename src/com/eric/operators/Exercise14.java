package com.eric.operators;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/16/2018 21:58
 */
public class Exercise14 {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = "hello";
        String s2 = new String(s1);
        compareString(s,s1);
        compareString(s,s2);
    }

    static void compareString(String s,String s1){
        print(s == s1);
        print(s != s1);
        print(s.equals(s1));
    }

    static void print(boolean b){
        System.out.println(b);
    }
}
