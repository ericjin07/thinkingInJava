package com.eric.strings;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/27/2018 8:02 PM
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
        String ss = mango.intern();
        System.out.println(ss);
    }
}
