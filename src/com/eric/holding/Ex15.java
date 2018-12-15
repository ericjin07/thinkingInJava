package com.eric.holding;

import java.util.LinkedList;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/11/2018 10:36 PM
 */
public class Ex15 {

    public static void main(String[] args) {
        LinkedList<Character> stact = new LinkedList<>();
        char carr[] = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---".toCharArray();
        char c;
        for (int i = 0; i < carr.length; i++)
            switch (c = carr[i]) {
                case '+':
                    stact.push(carr[++i]);
                    break;
                case '-':
                    System.out.print(stact.pop() + " ");
                    break;
            }
    }
}
