package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/20/2018 10:28 PM
 */
class ExceptionA extends Exception {
    ExceptionA(String msg) { super(msg); }
}

class ExceptionB extends Exception {
    ExceptionB(String msg) { super(msg); }
}

class ExceptionC extends Exception {
    ExceptionC(String msg) { super(msg); }
}

public class Ex9 {
    public static void f(int x) throws ExceptionA, ExceptionB, ExceptionC {
        if(x < 0) throw new ExceptionA("x < 0");
        if(x == 0) throw new ExceptionB("x == 0");
        if(x > 0) throw new ExceptionC("x > 0");
    }
    public static void main(String[] args) {
        try {
//            f(0);
            h();
            // will catch any Exception type:
        } catch(Exception e) {
            System.out.println("Caught Exception");
            e.printStackTrace(System.err);
            System.out.println("============");
            for (StackTraceElement st : e.getStackTrace())
                System.err.println(st);
            throw new NullPointerException();
        } finally {
            System.out.println("finally");
        }
    }

    public static void h() throws ExceptionC, ExceptionB, ExceptionA {
        f(1);
    }
}
