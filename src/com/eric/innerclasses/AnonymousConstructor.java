package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 5:01 PM
 */
public class AnonymousConstructor {
    public Base getBase(int x){
        return new Base(x) {
            {
                System.out.println("instance initalize");
            }
            @Override
            public void f() {
                System.out.println("ffff");
            }
        };
    }

    public static void main(String[] args) {
        AnonymousConstructor ac = new AnonymousConstructor();
        ac.getBase(9).f();

    }
}


abstract class Base{
    int val;

    public Base(int val) {
        System.out.println("base constuctor" + val);
        this.val = val;
    }

    public abstract void f();
}