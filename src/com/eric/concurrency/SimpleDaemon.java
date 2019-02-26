package com.eric.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 9:52 PM
 */
public class SimpleDaemon implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread() + "  " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
           Thread daemon =  new Thread(new SimpleDaemon());
           daemon.setDaemon(true);
           daemon.start();
        }
        System.out.println("All task start");
        TimeUnit.SECONDS.sleep(2);
    }
}
