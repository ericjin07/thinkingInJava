package com.eric.holding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/11/2018 10:01 PM
 */
public class Ex14 {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        int arr[] = {1,2,3,4,5,6,7};
        for (int x: arr)
            addMiddle(ll,x);
    }

    private static void addMiddle(LinkedList<Integer> ll, int x) {
        ListIterator<Integer> litr = ll.listIterator(ll.size()/2);
        litr.add(x);
        System.out.println(ll);
    }
}
