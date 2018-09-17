package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 4:42 PM
 */
public abstract class AbstractTest {

    public AbstractTest() {
        System.out.println("before");
        print(100);
        System.out.println("after");
    }

    abstract void print(int a);
}

class DeriveClass extends AbstractTest{

    private int value = 4;

    @Override
    void print(int a) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        DeriveClass deriveClass = new DeriveClass();
        deriveClass.print(33);
    }
}
