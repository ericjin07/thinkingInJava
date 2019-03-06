package com.eric.concurrency.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/25/2019 7:13 PM
 */
public class OrnamentalGarden_ex32 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch stoplatch = new CountDownLatch(1);
        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i,downLatch,stoplatch));
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stoplatch.countDown();

        downLatch.await();
        exec.shutdown();
        if (!exec.awaitTermination(250,TimeUnit.MILLISECONDS))
            System.out.println("Some task were not terminated");
        System.out.println("Total:" + Entrance.getTotalCount());
        System.out.println("Entrances Sum:" + Entrance.sumEntrances());
    }
}

class Count {
    private int count;
    private static Random rand = new Random(47);
    public synchronized int increment(){
        if (!rand.nextBoolean())
            Thread.yield();
        return count++;
    }

    public synchronized int getValue(){
        return count;
    }
}

class Entrance implements Runnable{
    private CountDownLatch donelatch;
    private CountDownLatch stoplatch;
    private static Count count = new Count();
    private final int id;
    private static List<Entrance> entrances = new ArrayList<>();

    public Entrance(int id,CountDownLatch donelatch, CountDownLatch stoplatch) {
        this.id = id;
        this.donelatch = donelatch;
        this.stoplatch = stoplatch;
        entrances.add(this);
    }

    private int number;

    @Override
    public void run() {
        while (stoplatch.getCount() != 0) {
            synchronized (this) {
                number++;
            }
            System.out.println(this + " Total:" + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        donelatch.countDown();
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue(){return number;}

    @Override
    public String toString() {
        return "Entrance " + id +  " : " + getValue();
    }

    public static int getTotalCount(){return count.getValue();}

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance e : entrances) {
            sum += e.getValue();
        }
        return sum;
    }
}
