package com.eric.concurrency;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/01/2019 4:48 PM
 */

public class ToastOMatic {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue
                dryQueue = new ToastQueue(),
                buttered = new ToastQueue(),
                finished = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,buttered));
        exec.execute(new Jammer(buttered,finished));
        exec.execute(new Eater(finished));
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}

class Toast {
    enum Status {DRY,BUTTERED,JAMMED}
    private final int id;
    private Status status;

    public Toast(int id) {
        this.id = id;
        status = Status.DRY;
    }

    public void butter(){status = Status.BUTTERED;}

    public void jam(){status = Status.JAMMED;}

    public Status getStatus(){return status;}

    public int getId(){return id;}

    @Override
    public String toString() {
        return "Toast {" +
                "id=" + id +
                "status=" + status +
                '}';
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable {
    private ToastQueue dryQueue;
    private int count;
    private static Random rand = new Random(47);

    public Toaster(ToastQueue dryQueue) {
        this.dryQueue = dryQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.MILLISECONDS.sleep(200 + rand.nextInt(500));
                //make toast
                Toast t = new Toast(count++);
                //put the toast into the queue
                dryQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupting");
        }
        System.out.println("Toaster off");
    }
}

class Butterer implements Runnable {

    private ToastQueue dryQueue;
    private ToastQueue butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //block util next toast is available
                Toast t = dryQueue.take();
                //butter the toast
                t.butter();
                System.out.println(t);
                //put the toast into the buttered Queue
                butteredQueue.put(t);
            }
        } catch (InterruptedException e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println("Butterer Interrupting");
            System.out.println(sw);
        }
        System.out.println("Butterer off");
    }
}

class Jammer implements Runnable {

    private ToastQueue butteredQueue;
    private ToastQueue finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //block util next toast is available
                Toast t = butteredQueue.take();
                //jam the toast
                t.jam();
                System.out.println(t);
                //put the toast into the finished Queue
                finishedQueue.put(t);
            }
        } catch (InterruptedException e){
            System.out.println("Jammer Interrupting");
        }
        System.out.println("Jammer off");
    }
}

class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int count;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //block util next toast is available
                Toast t = finishedQueue.take();
                //verify that the toast is coming in order
                // and that all pieces are getting jammed.
                if (t.getId() != count++ ||
                        t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>Error:" + t);
                }else
                    System.out.println("Chomp! " + t);
            }
        } catch (InterruptedException e){
            System.out.println("Eater Interrupting");
        }
        System.out.println("Eater off");
    }
}