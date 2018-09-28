package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/22/2018 12:33 PM
 */
public class Outer {

    public Inner getInner(){
        return new Inner();
    }

    class Inner{
        public Inner() {
            System.out.println("Inner.Constructor");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getInner());
        Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.getInner();
        System.out.println(inner);
        System.out.println(inner1);
    }
}
