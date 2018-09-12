package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/28/2018 22:36
 */
public class Exercise6 {

    static int test(int testval, int begin, int end){
        if (begin > end) {
            System.out.println("end can't less than begin");
            return 0;
        }
        if (testval >= begin && testval < end) {
            return 1;
        }else {
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(test(10, 5, 4));
        System.out.println(test(5, 4, 10));
        System.out.println(test(5, 5, 6));
        System.out.println(test(10, 5, 7));
        System.out.println(test(5, 5, 5));
    }
}
