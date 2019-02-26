package com.eric.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/26/2019 9:53 AM
 */
public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Sleep Interrupted");
        }
        System.out.println("Exiting SleepBlock.run()");
    }
}

class IOBlocked implements Runnable{
    private InputStream is;

    public IOBlocked(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read");
            is.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted())
                System.out.println("Interrupted from IO block");
            else
                throw new RuntimeException(e);
        }
        System.out.println("Exiting IO Block.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f(){
        while (true){
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
