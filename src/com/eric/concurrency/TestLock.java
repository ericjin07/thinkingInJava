package com.eric.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 9:35 PM
 */
public class TestLock implements Runnable{

    private Lock lock = new ReentrantLock();

    private void f(){
        lock.lock();
        try {
            lock.lock();
            System.out.println("locked by f()");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
            System.out.println("unlocked by f()");
        }
    }

    private void h(){
        try {
            lock.lockInterruptibly();
            System.out.println("locked by h()");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("unlocked by h()");
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
            f();
    }

    public static void main(String[] args) {
        TestLock tl = new TestLock();

        Runnable r = new Runnable(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted())
                    tl.h();
            }
        };
        new Thread(r).start();
        tl.run();
    }
}

