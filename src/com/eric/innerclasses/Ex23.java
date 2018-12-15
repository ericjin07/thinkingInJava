package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 9:32 PM
 */
/* Create an interface U with three methods. Create a class A with a method that
 * produces a reference to a U by building an anonymous inner class. Create a second
 * class B that contains an array of U. B should have one method that accepts and
 * stores a reference to U in the array, a second method that sets a reference in
 * the array (specified by the method argument) to null, and a third method that
 * moves through the array and calls the methods in U. In main, create a group of A
 * objects and a single B. Fill the B with U references produced by the A objects.
 * Use the B to call back into all the A objects. Remove some of the U references
 * from the B.
 */
public class Ex23 {

    public static void main(String[] args) {
        B b = new B(3);
        for (int i = 0; i < 3 ; i++){
            A a = new A();
            b.store(a.getU());
        }
        b.traverse();
        b.remove(2);
        System.out.println("=====");
        b.traverse();

    }
}

interface U{
    void f();
    void v();
    void w();
}

class B{
    int index = 0;
    U[] us;

    public B(int size) {
        us = new U[size];
    }

    void store(U u){
        if (index < us.length)
            us[index++] = u;
        else
            System.out.println("out of index");
    }

    void remove(int i){
        if (i < 0 || i >= us.length)
            System.out.println("out of index");
        else
            us[i] = null;
    }

    void traverse(){
        for (int i= 0; i< us.length; i++){
            U u = us[i];
            if(u != null){
                u.f();
                u.v();
                u.w();
            }
        }
    }
}

class A {
    public U getU(){
        return new U() {
            @Override
            public void f() {
                System.out.println("f");
            }

            @Override
            public void v() {
                System.out.println("v");
            }

            @Override
            public void w() {
                System.out.println("w");
            }
        };
    }
}
