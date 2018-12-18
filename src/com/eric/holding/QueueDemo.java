package com.eric.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 3:12 PM
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        while (queue.peek() != null)
            System.out.print(queue.remove() + "  ");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> qi = new LinkedList<>();
        Random rand = new Random(65);
        for (int i = 0; i < 10; i++) {
            qi.offer(rand.nextInt(1000));
        }
        printQ(qi);
        Queue<Character> qc = new LinkedList<>();
        for(char c : "fer42vdta 897VZXC".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }
}
