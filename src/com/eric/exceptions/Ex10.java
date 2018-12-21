package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/21/2018 10:56 PM
 */
public class Ex10 {

    public static void main(String[] args) {
        try {
            new Ex10().f();
        } catch (Exception10_b exception10_b) {
            exception10_b.printStackTrace();
        }
    }

    public void f() throws Exception10_b {
        try {
            g();
        } catch (Exception10_a exception10_a) {
//            Exception10_b b = new Exception10_b();
//            b.initCause(exception10_a);
            throw new RuntimeException(exception10_a);
        }
    }

    public void g() throws Exception10_a {
        System.out.println("throw from g()");
        throw new Exception10_a();
    }
}

class Exception10_a extends Exception{}
class Exception10_b extends Exception{}
