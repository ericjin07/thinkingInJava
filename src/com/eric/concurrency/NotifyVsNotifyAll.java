package com.eric.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 4:00 PM
 */
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task1());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            boolean pro = true;
            @Override
            public void run() {
                if (pro){
                    System.out.print("\nNotify::");
                    Task1.blocker.prod();
                    pro = false;
                }else {
                    System.out.print("\nNotifyAll::");
                    Task1.blocker.prodAll();
                    pro = true;
                }
            }
        }, 400,400);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("\nTimer cancel");
        timer.cancel();
        TimeUnit.SECONDS.sleep(2);
        System.out.print("Task2 notify All::");
        Task2.blocker.prodAll();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nshut down");
        exec.shutdownNow();
    }
}

class Blocker{

    public synchronized void waitingForCall() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                wait();
                System.out.print(Thread.currentThread() + "  ");
            }
        }catch (InterruptedException e) {
//            System.out.println("");
        }
    }

    public synchronized void prod(){notify();}
    public synchronized void prodAll(){notifyAll();}
}


class Task1 implements Runnable {

     static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingForCall();
    }
}


class Task2 implements Runnable {

     static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingForCall();
    }
}