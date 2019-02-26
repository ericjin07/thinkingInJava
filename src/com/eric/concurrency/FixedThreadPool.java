package com.eric.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 7:58 PM
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("==");
                new LiftOff().run();
            }
        };
        exec.execute(r);
        exec.shutdown();
    }
}
