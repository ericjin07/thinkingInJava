package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 5:08 PM
 */
public class CounterObj {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return "CounterObj{" +
                "id=" + id +
                '}';
    }
}
