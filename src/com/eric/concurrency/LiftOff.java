package com.eric.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 7:41 PM
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public void status(){
        System.out.print("#" + id + Thread.currentThread().getName() + "(" + (countDown > 0 ? countDown : "LiftOff") + "),");
    }
    @Override
    public void run() {
        while (--countDown > 0) {
            status();
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        LiftOff off = new LiftOff();
//        off.run();
//        System.out.println();
//        //start a thread
//        new Thread(new LiftOff()).start();

        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("waiting for lift off");

    }
}
