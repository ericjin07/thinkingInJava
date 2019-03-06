package com.eric.concurrency;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/04/2019 3:48 PM
 */
public class DeadlockingDiningPhilosophers {

    public static void main(String[] args) throws InterruptedException, IOException {
        int ponder = 5;
        int len = args.length;
        if (len > 0) ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (len > 1) size = Integer.parseInt(args[1]);

        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            if (i < size-1)
                exec.execute(new Philosopher(chopsticks[i],chopsticks[i+1],ponder,i));
            else exec.execute(new Philosopher(chopsticks[0],chopsticks[i],ponder,i));
        }
        if (len > 2 && args[2] == "timeout") TimeUnit.SECONDS.sleep(10);
        else {
            System.out.println("Press 'Enter' to exit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

class Chopstick {

    private boolean taken;

    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}

class Philosopher implements Runnable {

    private Chopstick right;
    private Chopstick left;
    private final int ponderFactor;
    private final int id;
    private static Random rand = new Random(47);

    public Philosopher(Chopstick right, Chopstick left, int ponderFactor, int id) {
        this.right = right;
        this.left = left;
        this.ponderFactor = ponderFactor;
        this.id = id;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0)return;
        else TimeUnit.MILLISECONDS.sleep(rand.nextInt(250 * ponderFactor));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " grabbing left");
                left.take();
                System.out.println(this + " eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
