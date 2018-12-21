package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/20/2018 10:16 PM
 */
public class Ex8 {

    public static void main(String[] args) throws Exception_4 {
        try {
            if (true) throw new Exception_4("faor");
        } catch (Exception_4 e) {
            System.out.println();
            e.showMessge();
            e.printStackTrace();
        }
    }
}
