package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 3:27 PM
 */
public class RecursiveFibonacci {
    static IntCall fib;

    public static void main(String[] args) {
        fib = n -> n == 0 ? 0 :
                   n == 1 ? 1 :
                   fib.call(n-1) + fib.call(n-2);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fib.call(i));
        }
    }
}
