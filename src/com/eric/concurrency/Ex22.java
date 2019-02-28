package com.eric.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 3:04 PM
 */
public class Ex22 {

    public static void main(String[] args) {
        Flag flag = new Flag();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Ta(flag));
        exec.execute(new Tb(flag));
        exec.shutdown();
    }
}

class Flag {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Ta implements Runnable{

    private Flag flag;

    public Ta(Flag f) {
        this.flag = f;
    }

    @Override
    public void run() {
        try {
            synchronized (flag) {
                System.out.println("A is sleeping");
                TimeUnit.SECONDS.sleep(2);
                flag.setFlag(true);
                flag.notifyAll();
            }
        } catch (InterruptedException e){
            System.out.println("Interrupt");
        }
    }
}

class Tb implements Runnable {

    private Flag flag;

    public Tb(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int sum = 0;
//        while (!flag.isFlag()) {
//            sum++;
//            Thread.yield();
//        }
        try {
            synchronized (flag) {
                System.out.println("I'm trying to waiting");
                if (!flag.isFlag())
                    wait();
            }
        }catch (InterruptedException e){
            System.out.println("Interrupt from wait");
        }
//        System.out.println("I was wait for " + sum + " times");
        flag.setFlag(false);
        System.out.println("the flag now is false");
    }
}