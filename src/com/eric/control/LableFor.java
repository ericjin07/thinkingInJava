package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/29/2018 20:42
 */
public class LableFor {

    public static void main(String[] args) {
        int i = 0;
        outer:
        for (;;){
            inner:
            for (;i<100;i++){
                System.out.println("i :" + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue out");
                    i++;
                    continue outer;
                }
                if (i == 9) {
                    System.out.println("break out");
                    break outer;
                }
                for (int k = 0; k< 5;k++){
                    if (k == 3){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
