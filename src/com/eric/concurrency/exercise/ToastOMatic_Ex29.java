package com.eric.concurrency.exercise;

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

public class ToastOMatic_Ex29 {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue
                dryQueue = new ToastQueue(),
                buttered = new ToastQueue(),
                jelly = new ToastQueue();
        SandwichQueue sandwiches= new SandwichQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new PeanutButterer(dryQueue,buttered));
        exec.execute(new Jelly(dryQueue,jelly));
        exec.execute(new SandwichMaker(buttered,jelly,sandwiches));
        exec.execute(new Eater(sandwiches));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

class Toast {
    enum Status {DRY,PEANUTBUTTER,JELLY}
    private final int id;
    private Status status;

    public Toast(int id) {
        this.id = id;
        status = Status.DRY;
    }

    public void peannutButter(){status = Status.PEANUTBUTTER;}

    public void jelly(){status = Status.JELLY;}

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
                TimeUnit.MILLISECONDS.sleep(150 + rand.nextInt(500));
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

class PeanutButterer implements Runnable {

    private ToastQueue dryQueue;
    private ToastQueue butteredQueue;

    public PeanutButterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
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
                t.peannutButter();
                System.out.println(t);
                //put the toast into the buttered Queue
                butteredQueue.put(t);
            }
        } catch (InterruptedException e){
            System.out.println("Butterer Interrupting");
        }
        System.out.println("Butterer off");
    }
}

class Jelly implements Runnable {

    private ToastQueue dryQueue;
    private ToastQueue jellyQueue;

    public Jelly(ToastQueue dryQueue, ToastQueue jellyQueue) {
        this.dryQueue = dryQueue;
        this.jellyQueue = jellyQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //block util next toast is available
                Toast t = dryQueue.take();
                //Jelly the toast
                t.jelly();
                System.out.println(t);
                //put the toast into the jelly Queue
                jellyQueue.put(t);
            }
        } catch (InterruptedException e){
            System.out.println("Jammer Interrupting");
        }
        System.out.println("Jammer off");
    }
}

class Sandwich {
    private Toast top,buttom;
    private final int id;

    public Sandwich(Toast top, Toast buttom, int id) {
        this.top = top;
        this.buttom = buttom;
        this.id = id;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getButtom() {
        return buttom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "top=" + top +
                ", buttom=" + buttom +
                ", id=" + id +
                '}';
    }
}

class SandwichQueue extends LinkedBlockingQueue<Sandwich>{}

//Make sandwich
class SandwichMaker implements Runnable{

    private ToastQueue butteredQueue,jellyQueue;
    private SandwichQueue sandwichQueue;
    private int count;

    public SandwichMaker(ToastQueue butteredQueue, ToastQueue jellyQueue, SandwichQueue sandwichQueue) {
        this.butteredQueue = butteredQueue;
        this.jellyQueue = jellyQueue;
        this.sandwichQueue = sandwichQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                //new sandwich
                Sandwich sandwich = new Sandwich(butteredQueue.take(),jellyQueue.take(),count++);
                System.out.println(sandwich);
                //put into sandwich queue
                sandwichQueue.put(sandwich);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupting Sandwich Maker");
        }
        System.out.println("Sandwich maker off");
    }
}

//Eater the Sandwich
class Eater implements Runnable {

    private SandwichQueue sandwichQueue;
    private int count;

    public Eater(SandwichQueue sandwichQueue) {
        this.sandwichQueue = sandwichQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //block util next sandwich is available
                Sandwich t = sandwichQueue.take();
                //verify that the toast is coming in order
                // and that all pieces are getting jammed.
                if (t.getId() != count++ ||
                        t.getTop().getStatus() != Toast.Status.PEANUTBUTTER ||
                        t.getButtom().getStatus() != Toast.Status.JELLY) {
                    System.out.println(">>>Error:" + t);
                }else
                    System.out.println("NumNum! " + t);
            }
        } catch (InterruptedException e){
            System.out.println("Eater Interrupting");
        }
        System.out.println("Eater off");
    }
}