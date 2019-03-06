package com.eric.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 10:17 AM
 */
public class WaxOMatic2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car2 car = new Car2();
        exec.execute(new WaxOn2(car));
        exec.execute(new WaxOff2(car));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

class WaxOn2 implements Runnable {
    private Car2 car;

    public WaxOn2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Wax ON");
                TimeUnit.SECONDS.sleep(1);
                car.waxed();
                car.waitForBuff();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit via Interrupt");
        }
        System.out.println("end of wax on");
    }
}

class WaxOff2 implements Runnable {
    private Car2 car;

    public WaxOff2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                car.waitForWaxing();
                System.out.println("Wax off");
                TimeUnit.SECONDS.sleep(1);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit via Interrupt");
        }
        System.out.println("end of wax off");
    }
}

class Car2 {
    private boolean waxOn = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waxed(){
        lock.lock();
        try {
            waxOn = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void waitForBuff() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
}
