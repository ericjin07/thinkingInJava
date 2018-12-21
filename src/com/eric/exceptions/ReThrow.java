package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/21/2018 8:46 AM
 */
public class ReThrow {

    public static void f() throws Exception {
        System.out.println("The originating Exception in f()");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Catch in g()");
            e.printStackTrace();
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Catch in h()");
            e.printStackTrace();
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("Catch in main");
            e.printStackTrace();
        }
        System.out.println("====================");
        try {
            h();
        } catch (Exception e) {
            System.out.println("Catch in main");
            e.printStackTrace();
        }


    }
}
