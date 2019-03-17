package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/07/2019 5:11 PM
 */
public class SemaphoreDemo {

    private static int SIZE = 25;

    public static void main(String[] args) throws Exception{
        final Pool<Fat> pool = new Pool<>(Fat.class,SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++)
            exec.execute(new CheckoutTask<>(pool));
        System.out.println("All checkout task created");
        List<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            System.out.println(i + " main() thread check out");
            f.operation();
            list.add(f);
        }
        Future<?> block = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        block.cancel(true); // Break out of blocked call
        System.out.println("Checking in objects in " + list);
        for(Fat f : list)
            pool.checkIn(f);
        for(Fat f : list)
            pool.checkIn(f); // Second checkIn ignored
        exec.shutdown();
    }
}

class CheckoutTask<T> implements Runnable {
    private static int counter;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " check out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " check in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask{" +
                "id=" + id + "}";
    }
}