package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/28/2018 17:45
 */
public class Exercise1 {

    public static void main(String[] args) {
        double prev = 0;
        while (true) {
            double curr = Math.random();
            if (prev > curr)
                System.out.println(prev + " great than " + curr);
            else if (prev == curr)
                System.out.println(prev + " equal " + curr);
            else
                System.out.println(prev + " less than " + curr);
            prev = curr;
        }
    }
}
