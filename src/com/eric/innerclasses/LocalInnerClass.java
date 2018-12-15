package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/19/2018 1:58 PM
 */
interface Counter{
    void next();
}

public class LocalInnerClass {

    private int count= 0;

    Counter getLocalCounter(String name){
        class LocalCounter implements Counter{
            public LocalCounter() {
                System.out.println("localcounter");
            }

            @Override
            public void next() {
                System.out.println(name + "  " + count++);
            }
        };
        return new LocalCounter();
    }

    Counter getAnonyCounter(String name){
        return new Counter() {
            {
                System.out.println("AnonymousCounter");
            }
            @Override
            public void next() {
                System.out.println(name + "  " + count++);
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass innerClass = new LocalInnerClass();
        Counter
                c1 = innerClass.getLocalCounter("local-------"),
                c2 = innerClass.getAnonyCounter("anonymous-----");
        for (int i = 0; i < 5; i++)
            c1.next();
        for (int i = 0; i < 5; i++)
            c2.next();
    }
}
