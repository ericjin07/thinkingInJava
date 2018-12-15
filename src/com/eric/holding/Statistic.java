package com.eric.holding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 11:40 AM
 */
public class Statistic {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
