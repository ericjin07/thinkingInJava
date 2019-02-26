package com.eric.concurrency;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 10:06 PM
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
//        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread() + "  " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("finally");
            }
//        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all task execute");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
