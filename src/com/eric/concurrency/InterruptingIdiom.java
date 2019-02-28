package com.eric.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/27/2019 4:11 PM
 */
public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1){
            System.out.println("usage: java Interrupting Idiom delay-in-ms");
            System.exit(0);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(Integer.parseInt(args[0]));
        t.interrupt();
    }
}

class NeedClean{
    private int id;

    public NeedClean(int id) {
        this.id = id;
    }

    public void clean(){
        System.out.println("clean id: " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                NeedClean n1 = new NeedClean(1);
                try {
                    System.out.println("sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedClean n2 = new NeedClean(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 25000000; i++)
                            d = d + (Math.PI + Math.E) / d;
                        System.out.println("Finished the time consuming operation");
                    } finally {
                        n2.clean();
                    }
                } finally {
                    n1.clean();
                }
            }
            System.out.println("Exit via while() test");
        }catch (Exception e){
            System.out.println("Exit via Interrupted Exception");
        }
    }
}
