package com.eric.holding;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 9:04 AM
 */
public class SetOfInterger {

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> setofI = new HashSet<>();
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 1000; i++) {
            set.add(random.nextInt(30));
            setofI.add(random.nextInt(40));
        }
        System.out.println(set);
        System.out.println(setofI);
    }
}
