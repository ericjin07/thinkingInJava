package com.eric.concurrency;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/12/2019 6:23 PM
 */
public class ReadWriteList<T> {
    private ArrayList<T> list;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReadWriteList(int size,T initValue) {
        list = new ArrayList<>(
                Collections.nCopies(size,initValue));
    }

    public T set(int index,T t) {
        final Lock wlock = lock.writeLock();
        wlock.lock();
        try {
//            System.out.println(lock.getWriteHoldCount() );
            return list.set(index,t);
        }finally {
            wlock.unlock();
        }
    }

    public T get(int index) {
        final Lock rlock = lock.readLock();
        rlock.lock();
        try {
            if (lock.getReadLockCount() > 0)
                System.out.println(lock.getReadLockCount());
            return list.get(index);
        }finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReadWriteTest(30,1);
    }

}

class ReadWriteTest {

    private ExecutorService exec = Executors.newCachedThreadPool();
    private static Random rand = new Random(48);
    private final static int SIZE = 100;
    private ReadWriteList<Integer> list = new ReadWriteList<>(SIZE,0);

    private class Read implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {

            }
        }
    }

    private class Write implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i,rand.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {

            }
            System.out.println("write finish");
            exec.shutdownNow();
        }
    }

    public ReadWriteTest(int reader,int writer) {
        for (int i = 0; i < reader; i++) {
            exec.execute(new Read());
        }

        for (int i = 0; i < writer; i++) {
            exec.execute(new Write());
        }
    }
}
