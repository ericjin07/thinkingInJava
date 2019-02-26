package com.eric.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/23/2019 2:44 PM
 */
public class CriticalSection {

    public static void testApproaches(PairManage pm1,PairManage pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pmp1 = new PairManipulator(pm1),
                pmp2 = new PairManipulator(pm2);
        PairCheck
                pc1 = new PairCheck(pm1),
                pc2 = new PairCheck(pm2);
        exec.execute(pmp1);
        exec.execute(pmp2);
        exec.execute(pc1);
        exec.execute(pc2);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
            e.printStackTrace();
        }
        System.out.println("pm1 " + pmp1 + "\npm2 " + pmp2);
        System.exit(0);
    }

    public static void main(String[] args) {
        testApproaches(new PairManage1(),new PairManage2());
    }

}

class Pair{
    private int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public void incrementX(){x++;}
    public void incrementY(){y++;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairNotEqualException extends RuntimeException{
        public PairNotEqualException() {
            super("pair not equal");
        }

    }
    public void checkState(){
        if (x != y)
            throw new PairNotEqualException();
    }
}

abstract class PairManage {
    protected Pair p = new Pair();
    AtomicInteger checkCount = new AtomicInteger(0);
    List<Pair> count = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair(){return new Pair(p.getX(),p.getY());}

    public void store(Pair p) {
        count.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract void increment();
}

class PairManage1 extends PairManage{

    @Override
    synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManage2 extends PairManage {
    @Override
    void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManage pm;

    public PairManipulator(PairManage pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair:" + pm.p + " checkCount:" + pm.checkCount.get();
    }
}

class PairCheck implements Runnable {

    private PairManage pm;

    public PairCheck(PairManage pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCount.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}