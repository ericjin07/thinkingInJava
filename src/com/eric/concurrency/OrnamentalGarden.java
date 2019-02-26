package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/25/2019 7:13 PM
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
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
    private static boolean canceled = false;
    private static Count count = new Count();
    private final int id;
    private static List<Entrance> entrances = new ArrayList<>();

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    private int number;
    public static void cancel(){canceled = true;}

    @Override
    public void run() {
        while (!canceled){
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
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue(){return number;}

    @Override
    public String toString() {
        return "Entrance " + id +  " : " + getValue();
    }

    public static int getTotalCount(){return count.getValue();}

    public static int sumEntrances(){
        int sum = 0;
        for (Entrance e : entrances){
            sum += e.getValue();
        }
        return sum;
    }
}
