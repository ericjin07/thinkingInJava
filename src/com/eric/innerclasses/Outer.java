package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/22/2018 12:33 PM
 */
public class Outer {
    private String out;

    public Outer(String out) {
        this.out = out;
    }

    public Inner getInner(){
        return new Inner();
    }

    class Inner{
        public Inner() {
            System.out.println("Inner.Constructor");
        }

        @Override
        public String toString() {
            return "out--" + out;
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer("ceafasdfa");
        System.out.println(outer.getInner());
        Outer.Inner inner1 = outer.getInner();
        System.out.println(inner1);
    }
}
