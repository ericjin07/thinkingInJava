package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/28/2018 17:53
 */
public class PrimeNumber {

    public static void main(String[] args) {
        for (int i=2;i<10000;i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i != j)
                        break;
                    else
                        System.out.println(i + ",");
                }
            }
        }
    }
}
