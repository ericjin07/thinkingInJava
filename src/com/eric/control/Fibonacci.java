package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/29/2018 21:02
 */
public class Fibonacci {
    
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int arg = Integer.parseInt(args[0]);
        System.out.println("First " + arg + "Fibonacci number(s) is: ");
        for (int i=1;i<=arg;i++)
            System.out.println(f.fibonacci(i));
        
    }

    private int fibonacci(int i) {
        if (i <= 2) return 1;
        else return fibonacci(i-2) + fibonacci(i-1);
    }
}
