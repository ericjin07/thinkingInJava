package com.eric.holding;

import java.util.PriorityQueue;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 4:02 PM
 */
public class Ex29_Priority {
    public static void main(String[] args) {
        PriorityQueue<SimpleObject> pq = new PriorityQueue<>();
        pq.add(new SimpleObject());
        pq.add(new SimpleObject());
        pq.add(new SimpleObject());
        System.out.println(pq);
    }
}

class SimpleObject implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
