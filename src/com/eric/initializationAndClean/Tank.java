package com.eric.initializationAndClean;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/04/2018 9:32 PM
 */
public class Tank {
    boolean filled = false;

    public Tank(boolean filled) {
        this.filled = filled;
    }

    void fill(){filled = true;}
    void empty(){filled = false;}

    @Override
    protected void finalize() throws Throwable {
        if (filled) {
            System.out.println("Error, The Tank is Filled");
        }
    }

    public static void main(String[] args) {
        Tank t1 = new Tank(true);
        Tank t2 = new Tank(true);
        t2.empty();
        t1 = new Tank(true);
        System.gc();
    }
}
