package com.eric.holding;

import java.util.LinkedList;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/11/2018 10:31 PM
 */
public class StackTest {

    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
