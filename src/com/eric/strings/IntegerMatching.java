package com.eric.strings;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/02/2019 7:14 PM
 */
public class IntegerMatching {

    public static void main(String[] args) {
        System.out.println("123".matches("-?\\d+"));
        System.out.println("-131223".matches("-?\\d+"));
        System.out.println("+131223".matches("-?\\d+"));
        System.out.println("+131223".matches("(-|\\+).\\d+"));
    }
}
