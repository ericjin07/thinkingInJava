package com.eric.containers;

import java.lang.ref.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/17/2019 10:50 PM
 */

public class References {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();
    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        System.out.println(inq);
        if (inq != null)
            System.out.println("Inq : " + inq.get());
    }

    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("soft" + i),rq));
            System.out.println("just create: " + sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("weak" + i),rq));
            System.out.println("just create: " + wa.getLast());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft---"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak---"));
        System.gc();
//        TimeUnit.MILLISECONDS.sleep(1000);
//        LinkedList<PhantomReference<VeryBig>> fa = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            fa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i),rq));
//            System.out.println("just create: " + fa.getLast());
//            checkQueue();
//        }
    }
}


class VeryBig{
    private final static int SIZE = 10000;
    private long[] la = new long[SIZE];
    private final String id;

    public VeryBig(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VeryBig{" +
                "id='" + id + '\'' +
                '}';
    }

    protected void finalize(){
        System.out.println("Finalizing " + id);
    }
}