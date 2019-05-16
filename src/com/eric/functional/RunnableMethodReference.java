package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 3:37 PM
 */
class Go {
    static void go() {
        System.out.println("Go::go()");
    }

    void goInstance() {
        System.out.println("Go::goInstance()");
    }
}
public class RunnableMethodReference {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();
        new Thread(()-> System.out.println("lambda")).start();
        new Thread(Go::go).start();
        new Thread(new Go()::goInstance).start();
    }
}
