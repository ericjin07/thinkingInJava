package com.eric.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/12/2019 10:10 AM
 */
public class SimpleMicroBenchMark {

    public static void main(String[] args) {
        long syncTime = test(new SynchronizingTest());
        long lockTime = test(new LockTest());
        System.out.printf("synchronized:%10d\n",syncTime);
        System.out.printf("Lock        :%1$10d\n",lockTime);
        System.out.printf("Lock/Synchronized = %1$.3f",(double)lockTime/(double)syncTime);
    }

    static long test(Incrementable incr) {
        long start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++)
            incr.increment();
        return System.nanoTime() - start;
    }
}

abstract class Incrementable{
    protected long counter = 0;
    abstract void increment();
}

class SynchronizingTest extends Incrementable {

    @Override
    synchronized void increment() {
        counter++;
    }
}

class LockTest extends Incrementable {
    private Lock lock = new ReentrantLock();

    @Override
    void increment() {
        lock.lock();
        try {
            counter++;
        }finally {
            lock.unlock();
        }
    }
}
