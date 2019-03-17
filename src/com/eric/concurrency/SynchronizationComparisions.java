package com.eric.concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/12/2019 10:21 AM
 */
public class SynchronizationComparisions {
}


abstract class Accumulator {
    public static long cycle = 5000L;
    private final static int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(2 * N);
    private CyclicBarrier barrier = new CyclicBarrier(2 * N + 1);
    protected volatile long index;
    protected volatile long value;
    protected String id = "Error";
    protected long duration;
    protected final static int SIZE = 10000;
    protected static int[] preload = new int[SIZE];
    private static Random rand = new Random(47);

    static {
        for (int i = 0; i < SIZE; i++) {
            preload[i] = rand.nextInt();
        }
    }

    abstract void accumulate();
    abstract long read();

    private class Modifier implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                accumulate();
            }
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Read implements Runnable {

        private volatile long value;
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                value = read();
            }
            try {
                barrier.await();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public void timeTest() {
        long start = System.nanoTime();
    }
}