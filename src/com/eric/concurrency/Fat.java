package com.eric.concurrency;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/07/2019 4:55 PM
 */
public class Fat implements Cloneable{
    private volatile double d;
    private static int counter;
    private final int id = counter++;

    public Fat() {
        //expensive,interruptible
        for (int i = 0; i < 25000; i++) {
            d += (Math.PI + Math.E) / (double)i;
        }
    }

    public void operation(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Fat f = new Fat();
        Fat cloneF = (Fat) f.clone();
        System.out.println(f);
        System.out.println(cloneF);
    }
}
