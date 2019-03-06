package com.eric.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/05/2019 6:32 PM
 */
public class CountDownDemo {

    private final static int SIZE = 100;
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //all must share a single CountDownLatch object
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("============");
        exec.shutdown();
    }
}

//perform some portion of a task
class TaskPortion implements Runnable{

    private static int c;
    private final CountDownLatch latch;
    private static int count;
    private final int id = count++;
    private static Random random = new Random(47);

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWorks();
        } catch (InterruptedException e) {
            System.out.println("Interrupted on sleep");
        }
        latch.countDown();
    }

    private void doWorks() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(++c +"  " + this + "completed");
    }

    @Override
    public String toString() {
        return "TaskPortion{" +
                "id=" + id +
                '}';
    }
}

//
class WaitingTask implements Runnable{
    private final CountDownLatch latch;
    private static int count;
    private final int id = count++;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println("interrupted by waiting");
        }
    }

    @Override
    public String toString() {
        return "WaitingTask{" +
                "id=" + id +
                '}';
    }
}
