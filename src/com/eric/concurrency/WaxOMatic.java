package com.eric.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 10:17 AM
 */
public class WaxOMatic {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car car = new Car();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(30);
        exec.shutdownNow();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Wax ON");
                TimeUnit.SECONDS.sleep(2);
                car.waxed();
                car.waitForBuff();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit via Interrupt");
        }
        System.out.println("end of wax on");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                car.waitForWaxing();
                System.out.println("Wax off");
                TimeUnit.SECONDS.sleep(2);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit via Interrupt");
        }
        System.out.println("end of wax off");
    }
}

class Car {
    private boolean waxOn = false;

    public synchronized void waxed(){
        waxOn = true;
        notify();
//        notifyAll();
    }

    public synchronized  void buffed() {
        waxOn = false;
//        notifyAll();
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuff() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}
