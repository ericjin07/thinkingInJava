package com.eric.holding;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/07/2019 8:03 PM
 */
public class ModifyingArrayAsList {

    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("before" + list1);
        Collections.shuffle(list1);
        System.out.println("aftere" + list1);
        System.out.println("array" + Arrays.toString(ia));
        System.out.println("===========");
        List<Integer> list2 = Arrays.asList(ia);
        Object[] list3 = list2.toArray();
        System.out.println("before" + list2);
        Collections.shuffle(list2);
        System.out.println("after" + list2);
        System.out.println("array" + Arrays.toString(ia));
    }
}
