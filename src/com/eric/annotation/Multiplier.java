package com.eric.annotation;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/17/2019 3:46 PM
 */
@ExtractInterface("IMultiplier")
public class Multiplier {
    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++)
            total = add(total,y);
        return total;
    }

    private int add(int x, int y){return x + y;}

    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
        System.out.println(multiplier.multiply(23,32));
    }
}
