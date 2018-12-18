package com.eric.holding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 3:55 PM
 */
public class Ex28_double {

    public static void main(String[] args) {
        Random rand = new Random(98);
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 15; i ++) {
            pq.add(rand.nextDouble());
        }
        while (pq.peek() != null)
            System.out.println(pq.poll());
    }
}
