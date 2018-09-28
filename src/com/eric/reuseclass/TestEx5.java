package com.eric.reuseclass;

import com.eric.interfaces.Ex5;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 5:45 PM
 */
public class TestEx5 implements Ex5 {
    @Override
    public void sayOne() {
        System.out.println("say one");
    }

    @Override
    public void sayTwo() {
        System.out.println("say Two");
    }

    @Override
    public void sayThree() {
        System.out.println("say Three");
    }

    public static void main(String[] args) {
        Ex5 ex5 = new TestEx5();
        ex5.sayOne();
        ex5.sayTwo();
        ex5.sayThree();
    }
}
