package com.eric.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/20/2019 10:14 PM
 */
public class AtomicTest implements Runnable {

    private int i;

    public synchronized int getValue(){return i;}

    public synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicTest at = new AtomicTest();
        exec.execute(at);
        TimeUnit.MILLISECONDS.sleep(1);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Abort");
                System.exit(0);
            }
        },4000);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
