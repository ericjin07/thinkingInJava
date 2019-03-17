package com.eric.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/12/2019 6:03 PM
 */
public class FastSimulation {
    private final static int N_ELEMENTS = 100000;
    private final static int N_GENES = 30;
    private final static int N_EVOLVE = 50;
    private static AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENES];
    private static Random rand = new Random(47);

    static class Evolver implements Runnable {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                int element = rand.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int prev = element - 1;
                    if (prev < 0) prev = N_ELEMENTS - 1;
                    int next = element + 1;
                    if (next >= N_ELEMENTS) next = 0;
                    int oldValue = GRID[element][i].get();
                    int newValue = oldValue + GRID[prev][i].get() + GRID[next][i].get();
                    newValue /= 3;
                    if (!GRID[element][i].compareAndSet(oldValue,newValue)){
                        System.out.println("Old value change from " + oldValue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++)
            for (int j = 0; j < N_GENES; j++)
                GRID[i][j] = new AtomicInteger(rand.nextInt(1000));
        for (int i = 0; i < N_EVOLVE; i++)
            exec.execute(new Evolver());
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();

    }
}
