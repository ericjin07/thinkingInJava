package com.eric.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/10/2018 10:12 PM
 */
public class Ex12 {

    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            first.add(i);
        System.out.println(first);
        List<Integer> second = new ArrayList<>(10);
        ListIterator<Integer> itr = first.listIterator(10);
        while (itr.hasPrevious())
            second.add(itr.previous());
        System.out.println(second);
    }
}
