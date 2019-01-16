package com.eric.typeinfo;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/08/2019 10:52 PM
 */
public class Ex10 {

    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        Class t = chars.getClass();
        System.out.println(t.getSuperclass());
        System.out.println("char[] chars instance of Object? " + (chars instanceof Object));
        System.out.println(int.class);
        System.out.println(Integer.TYPE);
    }
}
