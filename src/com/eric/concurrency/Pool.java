package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/07/2019 4:41 PM
 */
public class Pool<T> {

    private int size;
    private Semaphore available;
    private List<T> item = new ArrayList<>();
    private boolean[] checkOut;

    public Pool(Class<T> objClz,int size) {
        this.size = size;
        available = new Semaphore(size,true);
        checkOut = new boolean[size];
        for (int i = 0; i < size; i++) {
            try {
                item.add(objClz.newInstance());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkOut[i])
                return item.get(i);
        }
        return null;
    }

    public void checkIn(T t) {
        if (releaseItem(t))
            available.release();
    }

    private synchronized boolean releaseItem(T t) {
        int i = item.indexOf(t);
        if (i == -1) return false;        //not in item list
        if (checkOut[i]){
            checkOut[i] = false;
            return true;
        }
        return false;
    }
}
