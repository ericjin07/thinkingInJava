package com.eric.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/19/2018 8:11 PM
 */
public class Ex1_3 {

    private static Logger logger = Logger.getLogger("Ex3");

    public static void main(String[] args) {
        try {
            System.out.println("ex1");
            throw new Exception("a new Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("========");
            e.printStackTrace(System.out);
        } finally {
            System.out.println("here is the finally");
        }

        //EX2====
        Ex1_3 ex1 = null;
        try {
            ex1.f();
        } catch (NullPointerException n){
            System.out.println("catch the null");
        }

        System.out.println("==========");

        //EX3======
        String a[] = "new hall word thi".split(" ");
        try {
            for (int i = 0; i <= a.length; i++) {
                System.out.println(a[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
            System.out.println("===========");
            logException(e);
            logger.severe(e.getMessage());
        }
    }

    public static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public void f(){
        System.out.println("ffff");
    }
}
