package com.eric.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/23/2019 3:22 PM
 */
public class SyncObject {

    public static void main(String[] args) {
        DualSync dualSync = new DualSync();
//        new Thread(()-> dualSync.f()).start();
//        new Thread(()-> dualSync.h()).start();
        new Thread(()-> dualSync.a()).start();
        new Thread(()-> dualSync.b()).start();
        new Thread(()-> dualSync.c()).start();
//        dualSync.g();
    }
}

class DualSync{
    private Object syncObj = new Object();
    private Object syncObj2 = new Object();

    private ReentrantLock lock = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();
    private ReentrantLock lock3 = new ReentrantLock();

    public  void a(){
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaa()");
            }
        }finally {
            lock.unlock();
        }
    }

    public  void b(){
        lock2.lock();
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bbbbb()");
            }
        }finally {
            lock2.unlock();
        }
    }

    public void c(){
        lock3.lock();
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("cccc()");
            }
        }finally {
            lock3.unlock();
        }
    }


    public synchronized void g(){
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("g()");
        }
    }

    public void f(){
        synchronized (syncObj){
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f()");
            }
        }
    }

    public void h(){
        synchronized (syncObj){
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("h()");
            }
        }
    }
}
