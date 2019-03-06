package com.eric.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 2:56 PM
 */
public class Ex21 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Ar a = new Ar();
        Br b = new Br(a);
        exec.execute(a);

        System.out.println("sleeping");
        TimeUnit.SECONDS.sleep(3);

        exec.execute(b);
        exec.shutdown();
    }
}

class Ar implements Runnable{

    @Override
    public void run() {
        System.out.println("A is wait at run()");
        try {
            synchronized (this) {
                wait();
                System.out.println("A is done the task");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Br implements Runnable{

    private final Ar a;

    public Br(Ar a) {
        this.a = a;
    }

    @Override
    public void run() {
        synchronized (a){
            System.out.println("notify a in B.run()");
            a.notifyAll();
        }
    }
}
