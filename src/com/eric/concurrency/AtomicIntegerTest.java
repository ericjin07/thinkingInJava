package com.eric.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/21/2019 10:56 PM
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger ait = new AtomicInteger(0);

    public int get(){return ait.get();}

    public void evenIncrement(){
        ait.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Abort");
                System.exit(0);
            }
        }, 5000);
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true){
            int i = ait.get();
            if (i % 2 != 0) {
                System.out.println(i);
                System.exit(0);
            }
        }

    }

}
