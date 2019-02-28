package com.eric.concurrency;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/27/2019 3:53 PM
 */
public class Interrupt2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}

class BlockMutex{
    private Lock lock = new ReentrantLock();

    public BlockMutex() {
        lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable{
    private BlockMutex lock = new BlockMutex();

    @Override
    public void run() {
        System.out.println("waiting for f() in BlockMutex");
        lock.f();
        System.out.println("Broke out of the blocked call");
    }
}
